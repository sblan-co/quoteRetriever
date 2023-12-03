package com.sblanco.controller

import com.sblanco.model.Quote
import com.sblanco.service.QuoteService
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/quote")
class QuoteController (
    private val quoteService: QuoteService
) {
    @Post(value = "/create", processes = [MediaType.APPLICATION_JSON])
    @Status(HttpStatus.CREATED)
      fun create(@Body quoteRequest: Quote) : Quote = quoteService.create(quoteRequest)

    @Get("/list")
    fun list(): Iterable<Quote> = quoteService.list()

    @Get("/{id}")
    fun findById(@PathVariable id: String): Quote = quoteService.findById(id)

    @Get("/q")
    fun findByAuthor(@QueryValue author: String): Iterable<Quote> = quoteService.findByAuthor(author)
}