package com.vishnus1224.dicto.data.model

import com.google.gson.annotations.SerializedName

internal data class Inflection(val id: String, val text: String)

internal data class InflectionsResult(val id: String, @SerializedName("inflectionOf") val inflections: List<Inflection>)

data class InflectionsResponse internal constructor(val results: List<InflectionsResult>)