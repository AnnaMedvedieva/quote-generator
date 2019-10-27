package org.company.example.annaunderwood.quotegenerator.Network

import com.squareup.moshi.Json

data class Quote( @Json(name = "_id") val id: String,
                  val quoteText: String,
                  val quoteAuthor: String)

