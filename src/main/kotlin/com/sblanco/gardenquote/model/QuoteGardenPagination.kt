package com.sblanco.gardenquote.model

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class QuoteGardenPagination(
    val currentPage: Int,
    val nextPage: Int,
    val totalPages: Int
)
