package com.example.example

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RandomRegion (
  @Json(name = "name") var name: String?= null,
  @Json(name = "topLevelDomain") var topLevelDomain : ArrayList<String> = arrayListOf(),
  @Json(name = "alpha2Code") var alpha2Code: String? = null,
  @Json(name = "alpha3Code") var alpha3Code     : String?                  = null,
  @Json(name = "callingCodes") var callingCodes   : ArrayList<String>        = arrayListOf(),
  @Json(name = "capital") var capital        : String?                  = null,
  @Json(name = "altSpellings") var altSpellings   : ArrayList<String>        = arrayListOf(),
  @Json(name = "subregion") var subregion      : String?                  = null,
  @Json(name = "region") var region         : String?                  = null,
  @Json(name = "population") var population     : Int?                     = null,
  @Json(name = "latlng") var latlng         : ArrayList<Int>           = arrayListOf(),
  @Json(name = "demonym") var demonym        : String?                  = null,
  @Json(name = "area") var area           : Int?                     = null,
  @Json(name = "timezones") var timezones      : ArrayList<String>        = arrayListOf(),
  @Json(name = "borders") var borders        : ArrayList<String>        = arrayListOf(),
  @Json(name = "nativeName") var nativeName     : String?                  = null,
  @Json(name = "numericCode") var numericCode    : String?                  = null,
  @Json(name = "flags") var flags          : Flags  ?                   = Flags(),
  @Json(name = "currencies") var currencies     : ArrayList<Currencies>    = arrayListOf(),
  @Json(name = "languages") var languages      : ArrayList<Languages>     = arrayListOf(),
  @Json(name = "translations") var translations   : Translations?            = Translations(),
  @Json(name = "flag") var flag           : String?                  = null,
  @Json(name = "regionalBlocs") var regionalBlocs  : ArrayList<RegionalBlocs> = arrayListOf(),
  @Json(name = "cioc") var cioc           : String?                  = null,
  @Json(name = "independent") var independent    : Boolean?                 = null

) : Parcelable {
  constructor(parcel: Parcel) : this(
    parcel.readString(),
    TODO("topLevelDomain"),
    parcel.readString(),
    parcel.readString(),
    TODO("callingCodes"),
    parcel.readString(),
    TODO("altSpellings"),
    parcel.readString(),
    parcel.readString(),
    parcel.readValue(Int::class.java.classLoader) as? Int,
    TODO("latlng"),
    parcel.readString(),
    parcel.readValue(Int::class.java.classLoader) as? Int,
    TODO("timezones"),
    TODO("borders"),
    parcel.readString(),
    parcel.readString(),
    TODO("flags"),
    TODO("currencies"),
    TODO("languages"),
    TODO("translations"),
    parcel.readString(),
    TODO("regionalBlocs"),
    parcel.readString(),
    parcel.readValue(Boolean::class.java.classLoader) as? Boolean
  ) {
  }

  override fun writeToParcel(parcel: Parcel, flags: Int) {
    parcel.writeString(name)
    parcel.writeString(alpha2Code)
    parcel.writeString(alpha3Code)
    parcel.writeString(capital)
    parcel.writeString(subregion)
    parcel.writeString(region)
    parcel.writeValue(population)
    parcel.writeString(demonym)
    parcel.writeValue(area)
    parcel.writeString(nativeName)
    parcel.writeString(numericCode)
    parcel.writeString(flag)
    parcel.writeString(cioc)
    parcel.writeValue(independent)
  }

  override fun describeContents(): Int {
    return 0
  }

  companion object CREATOR : Parcelable.Creator<RandomRegion> {
    override fun createFromParcel(parcel: Parcel): RandomRegion {
      return RandomRegion(parcel)
    }

    override fun newArray(size: Int): Array<RandomRegion?> {
      return arrayOfNulls(size)
    }
  }
}