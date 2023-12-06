package com.sblanco.gardenquote.service

import com.sblanco.gardenquote.QuoteGardenConfiguration
import com.sblanco.gardenquote.model.QuoteGardenApiResponse
import io.micronaut.core.type.Argument
import io.micronaut.http.*
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.uri.UriBuilder
import jakarta.inject.Singleton
import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber
import java.net.URI

@Singleton
class QuoteDbFillerService(
    @param:Client(id = "quote-garden")
    private val httpClient: HttpClient,
    configuration: QuoteGardenConfiguration
) {
    private val uri: URI = UriBuilder.of("/api")
        .path(configuration.version)
        .path(configuration.endpoint)
//        .queryParam("limit", configuration.limit)
        .build()

    fun fill(): Publisher<QuoteGardenApiResponse> {
        val getRequest = HttpRequest.GET<Any>(uri)
            .header(HttpHeaders.USER_AGENT, "Micronaut HTTP Client")
            .header(HttpHeaders.ACCEPT, "application/vnd.github.v3+json, application/json")
        val getResponse = httpClient.retrieve(
            getRequest,
            Argument.of(QuoteGardenApiResponse::class.java)
        )

//        getResponse.subscribe(println(it))

        return getResponse

//        val apiResponse: QuoteGardenApiResponse =
//        if (apiResponse.statusCode == HttpStatus.OK && apiResponse.data.isNotEmpty()) {
//            apiResponse.data.forEach {
//               quoteService?.create(it.toQuote())
//            }
//        }
    }
}