package com.example.example

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class RegionalBlocs (

  @Json(name = "acronym") var acronym : String? = null,
  @Json(name = "name") var name    : String? = null

)