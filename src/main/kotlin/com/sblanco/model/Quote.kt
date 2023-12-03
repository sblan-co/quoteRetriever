package com.sblanco.model

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Version

@MappedEntity
data class Quote(
    @field: Id
    @field: GeneratedValue
    val _id: String? = null,
    val quote: String,
    val author: String,
    val genre: String,
    @field: Version
    @field: GeneratedValue
    val __v: Int? = null
)
