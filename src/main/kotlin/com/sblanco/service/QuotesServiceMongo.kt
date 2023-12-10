package com.sblanco.service

import com.sblanco.model.Quote
import com.sblanco.repository.QuotesRepository
import io.micronaut.core.annotation.NonNull
import jakarta.inject.Singleton
import java.util.Optional

@Singleton
class QuotesServiceMongo (
    private val quotesRepository: QuotesRepository
) : QuotesService
{
    override fun create(quote: Quote): Quote {
        return quotesRepository.save(quote)
    }

    override fun list(): List<Quote> {
        return quotesRepository.findAll()
    }

    override fun findById(id: @NonNull String): Optional<Quote> {
        return quotesRepository.findById(id)
    }

    override fun findByAuthor(author: @NonNull String): List<Quote> {
        return quotesRepository.findByAuthor(author)
    }
}