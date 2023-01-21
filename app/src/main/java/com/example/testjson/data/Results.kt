package com.example.testjson.data

import com.example.example.RandomRegion
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Results(
        @Json(name = "results") val results: Array<RandomRegion>
    )



