package com.sblanco.gardenquote.model

import com.sblanco.quote.model.Quote
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class QuoteGarden(
    val _id: String,
    val quoteText: String,
    val quoteAuthor: String,
    val quoteGenre: String,
    val __v: Int
) {
    // fixme maybe not needed
    fun toQuote(): Quote {
        return Quote(
            _id = this._id,
            quote = this.quoteText,
            author = this.quoteAuthor,
            genre = this.quoteGenre,
            __v = this.__v
        )
    }
}
