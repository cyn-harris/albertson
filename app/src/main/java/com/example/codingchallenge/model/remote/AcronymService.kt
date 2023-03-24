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
    suspend fun getWordFromAcronym(@Query(SF) initials: String): Response<ArrayList<ShortForResponseItem>>

    companion object {
        const val DICT_ENDPOINT = "dictionary.py"
        const val SF = "sf"
    }
}
