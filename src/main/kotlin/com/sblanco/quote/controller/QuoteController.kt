package com.sblanco.quote.controller

import com.sblanco.gardenquote.model.QuoteGardenApiResponse
import com.sblanco.gardenquote.service.QuoteDbFillerService
import com.sblanco.quote.model.Quote
import com.sblanco.quote.service.QuoteService
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import org.reactivestreams.Publisher

@Controller("/quote")
class QuoteController (
    private val quoteService: QuoteService,
    private val quoteDbFillerService: QuoteDbFillerService
) {
    @Post(value = "/create", processes = [MediaType.APPLICATION_JSON])
    @Status(HttpStatus.CREATED)
    fun create(@Body quoteRequest: Quote) : Quote = quoteService.create(quoteRequest)

    @Get("/list")
//    fun list(): Iterable<Quote> {
    fun list(): Publisher<QuoteGardenApiResponse> {
        val quoteList = quoteService.list()
        if (quoteList.toList().isEmpty()) {
            quoteDbFillerService.fill()
        }
        return quoteDbFillerService.fill()
//        return quoteService.list()
    }

    @Get("/{id}")
    fun findById(@PathVariable id: String): Quote = quoteService.findById(id)

    @Get("/q")
    fun findByAuthor(@QueryValue author: String): Iterable<Quote> = quoteService.findByAuthor(author)
}