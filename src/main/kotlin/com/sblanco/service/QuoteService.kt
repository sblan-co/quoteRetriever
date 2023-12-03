package com.sblanco.service

import com.sblanco.model.Quote
import com.sblanco.repository.QuoteRepository
import io.micronaut.core.annotation.NonNull
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Singleton

@Singleton
class QuoteService (
    private val quoteRepository: QuoteRepository
) {
    fun create(quote: Quote): Quote {
        return quoteRepository.save(quote)
    }

    fun list(): Iterable<Quote> {
        return quoteRepository.findAll()
    }

    fun findById(id: @NonNull String): Quote {
        return quoteRepository.findById(id)
            .orElseThrow { HttpStatusException(HttpStatus.NOT_FOUND, "Quote with id $id not found.")}
    }

    fun findByAuthor(author: String): Iterable<Quote> {
        return quoteRepository.findByAuthor(author)
    }
}