package com.sblanco.repository

import com.sblanco.model.Quote
import io.micronaut.core.annotation.NonNull
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository

@MongoRepository
interface QuotesRepository : CrudRepository<Quote, String> {
    fun findByAuthor(author: @NonNull String): List<Quote>
}