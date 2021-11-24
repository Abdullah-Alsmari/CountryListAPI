package com.example.flaglistbyretrofitmoshi

import com.squareup.moshi.Json

data class CountryModel(val error : Boolean,val msg:String,val data : List<Data>)

data class Data(@Json(name="name")val name: String,@Json(name="flag") val flag : String)