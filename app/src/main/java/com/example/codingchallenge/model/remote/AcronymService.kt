package com.example.codingchallenge.model.remote

import com.example.codingchallenge.model.dto.ShortForResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Acronym service.
 *
 * @constructor Create empty Acronym service
 */
interface AcronymService {
    @GET(DICT_ENDPOINT)
    fun getWordFromAcronym(@Query("sf") initials: String): Response<ArrayList<ShortForResponseItem>>

    companion object {
        const val DICT_ENDPOINT = "dictionary.py"
    }
}
