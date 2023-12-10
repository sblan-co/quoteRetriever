package com.sblanco

import com.sblanco.model.Quote
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.http.client.annotation.Client

@Client("/quotes")
interface QuotesClient {

    @Post
    @Status(HttpStatus.CREATED)
    fun create(@Body quoteRequest: Quote) : Quote

    @Get
    fun list(): List<Quote>

    @Get("/{id}")
    fun findById(@PathVariable id: String): Quote

    @Get("author={author}")
    fun findByAuthor(@QueryValue author: String): List<Quote>
}