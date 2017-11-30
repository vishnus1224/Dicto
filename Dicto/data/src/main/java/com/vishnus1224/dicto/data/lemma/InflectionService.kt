package com.vishnus1224.dicto.data.lemma

import com.vishnus1224.dicto.data.webservice.WebService

/**
 * Get the root form of a word i.e inflection of the word.
 * This root form will be used to find the meaning.
 */
suspend fun getInflection(word: String, webService: WebService): String {
    val response = webService.inflections(word).execute()

}