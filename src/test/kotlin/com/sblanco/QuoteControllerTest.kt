package com.sblanco

import com.sblanco.model.Quote
import com.sblanco.service.QuoteService
import io.micronaut.context.annotation.Replaces
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Inject
import jakarta.inject.Singleton
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class QuoteControllerTest
{
    @Inject
    val quoteClient = QuoteControllerMock()

    @Test
    fun emptyDatabaseContainsNoQuote() {
        Assertions.assertEquals(0, quoteClient.list().toList().size)
    }

    @Test
    fun testCreateAndListWithTheController() {
        var quote: Quote = quoteClient.create(Quote(quote = "quote1", author = "author1", genre = "genre1"))
        var quoteList: List<Quote> = quoteClient.list().toList()

        Assertions.assertEquals(1, quoteList.size)
        Assertions.assertEquals(quote, quoteList[0])

        quote = quoteClient.create(Quote(quote = "quote2", author = "author2", genre = "genre2"))
        quoteList = quoteClient.list().toList()

        Assertions.assertEquals(2, quoteList.size)
        Assertions.assertEquals(quote, quoteList[1])
    }

    @Test
    fun testFindById() {
        val quote = Quote(_id = "id1", quote = "quote1", author = "author1", genre = "genre1")
        quoteClient.create(quote)

        val notFoundQuoteResponse = Assertions.assertThrows(HttpStatusException::class.java) {
            quoteClient.findById("id2")
        }
        Assertions.assertEquals(HttpStatus.NOT_FOUND, notFoundQuoteResponse.status)
        Assertions.assertEquals("Quote with id id2 not found.", notFoundQuoteResponse.message)

        val foundQuote: Quote = quoteClient.findById("id1")
        Assertions.assertEquals(quote, foundQuote)
    }

    @Test
    fun testFindByAuthor() {
        val quote1 = Quote(quote = "quote1", author = "author1", genre = "genre1")
        val quote2 = Quote(quote = "quote2", author = "author2", genre = "genre2")
        val quote3 = Quote(quote = "quote3", author = "author2", genre = "genre3")
        val expectedQuotes = listOf(quote2, quote3).asIterable()
        quoteClient.create(quote1)
        quoteClient.create(quote2)
        quoteClient.create(quote3)

        val quotes: Iterable<Quote> = quoteClient.findByAuthor("author2")
        Assertions.assertEquals(expectedQuotes, quotes)
    }


    @Singleton
    @Replaces(QuoteService::class)
    @Requires(property = "spec.name", value = "controller-isolation")
    class QuoteControllerMock : QuoteClient {
        private var quoteList: Iterable<Quote> = emptyList()

        override fun create(quoteRequest: Quote): Quote {
            quoteList = quoteList.plus(quoteRequest)
            return quoteRequest
        }

        override fun list(): Iterable<Quote> {
            return quoteList
        }

        override fun findById(id: String): Quote {
            val foundQuote = quoteList.filter { it._id == id }

            if (foundQuote.isNotEmpty()) {
                return foundQuote[0]
            } else {
                throw HttpStatusException(HttpStatus.NOT_FOUND, "Quote with id $id not found.")
            }
        }

        override fun findByAuthor(author: String): Iterable<Quote> {
            return quoteList.filter { it.author == author }.asIterable()
        }
    }
}