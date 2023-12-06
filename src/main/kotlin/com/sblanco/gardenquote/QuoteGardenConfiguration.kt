package com.sblanco.gardenquote

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.context.annotation.Requires

@ConfigurationProperties(QuoteGardenConfiguration.PREFIX)
@Requires(property = QuoteGardenConfiguration.PREFIX)
class QuoteGardenConfiguration {
    var version: String? = null
    var endpoint: String? = null
    var limit: Int? = null

    companion object {
        const val PREFIX = "quote-garden"
    }
}