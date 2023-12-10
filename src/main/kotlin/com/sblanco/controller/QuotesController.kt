package com.sblanco.controller

import com.sblanco.model.Quote
import com.sblanco.service.QuotesService
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.http.exceptions.HttpStatusException

@Controller("/quotes")
class QuotesController (
    private val quotesService: QuotesService
) {
    @Post
    @Status(HttpStatus.CREATED)
    fun create(@Body quoteRequest: Quote) : Quote = quotesService.create(quoteRequest)

    @Get
    fun list(): Iterable<Quote> = quotesService.list()

    @Get("/{id}")
    fun findById(@PathVariable id: String): Quote {
        return quotesService.findById(id)
            .orElseThrow { HttpStatusException(HttpStatus.NOT_FOUND, "Quote with id $id not found.") }
    }

    @Get("author={author}")
    fun findByAuthor(@QueryValue author: String): List<Quote> = quotesService.findByAuthor(author)
}