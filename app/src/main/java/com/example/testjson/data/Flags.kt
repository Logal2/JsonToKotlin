package com.example.example

import com.squareup.moshi.Json


data class Flags(

  @Json(name = "png") var png : String? = null

)