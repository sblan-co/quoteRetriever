package com.sblanco.quote.repository

import com.sblanco.quote.model.Quote
import io.micronaut.core.annotation.NonNull
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository

@MongoRepository
interface QuoteRepository : CrudRepository<Quote, String> {
    fun findByAuthor(author: @NonNull String): Iterable<Quote>
}