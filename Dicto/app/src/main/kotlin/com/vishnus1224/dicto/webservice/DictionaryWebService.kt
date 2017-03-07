package com.vishnus1224.dicto.webservice

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Vishnu on 3/7/2017.
 */
interface DictionaryWebService {

    @GET("references/collegiate/xml/{word}")
    fun getMeaning(@Path("word") word: String) : Unit
}