package com.sblanco.gardenquote.model

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class QuoteGardenApiResponse(
    val statusCode: Int,
    val message: String,
    val pagination: QuoteGardenPagination,
    val totalQuotes: Int,
    val data: List<QuoteGarden>
)
