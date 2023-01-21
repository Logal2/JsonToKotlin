package com.example.example

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json


data class Currencies (

  @Json(name = "code") var code   : String? = null,
  @Json(name = "name") var name   : String? = null,
  @Json(name = "symbol") var symbol : String? = null

)