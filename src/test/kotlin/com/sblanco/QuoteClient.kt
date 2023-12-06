package com.sblanco

import com.sblanco.quote.model.Quote
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.http.client.annotation.Client

@Client("/quote")
interface QuoteClient {

    @Post(value = "/create", processes = [MediaType.APPLICATION_JSON])
    @Status(HttpStatus.CREATED)
    fun create(@Body quoteRequest: Quote) : Quote

    @Get("/list")
    fun list(): Iterable<Quote>

    @Get("/{id}")
    fun findById(@PathVariable id: String): Quote

    @Get("/q")
    fun findByAuthor(@QueryValue author: String): Iterable<Quote>
}