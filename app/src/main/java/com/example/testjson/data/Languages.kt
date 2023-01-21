package com.example.example

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class Languages (

  @Json(name = "iso639_1") var iso6391    : String? = null,
  @Json(name = "iso639_2") var iso6392    : String? = null,
  @Json(name = "name") var name       : String? = null,
  @Json(name = "nativeName") var nativeName : String? = null

)