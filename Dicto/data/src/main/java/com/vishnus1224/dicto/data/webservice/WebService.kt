package com.vishnus1224.dicto.data.webservice

import com.vishnus1224.dicto.data.model.EntriesResponse
import com.vishnus1224.dicto.data.model.InflectionsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {

    @GET("inflections/en/{name}")
    fun inflections(@Path("name") wordName: String): Call<InflectionsResponse>

    @GET("entries/en/{name}")
    fun entries(@Path("name") wordName: String): Call<EntriesResponse>
}