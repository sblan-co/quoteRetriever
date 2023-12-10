package com.sblanco.service

import com.sblanco.model.Quote
import io.micronaut.core.annotation.NonNull
import java.util.*

interface QuotesService {

    fun create(quote: Quote): Quote

    fun list(): List<Quote>

    fun findById(id: @NonNull String): Optional<Quote>

    fun findByAuthor(author: @NonNull String): List<Quote>
}