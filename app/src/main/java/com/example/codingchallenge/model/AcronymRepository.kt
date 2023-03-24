package com.example.codingchallenge.model

import com.example.codingchallenge.model.remote.AcronymService
import javax.inject.Inject

/**
 * Acronym repository.
 *
 * @property acronymService
 * @constructor Create empty Acronym repository
 */
class AcronymRepository @Inject constructor(private val acronymService: AcronymService) {
    /**
     * Get words from acronym.
     *
     * @param acronym
     * @return
     */
    suspend fun getWordsFromAcronym(acronym: String): List<String> {
        return acronymService.getWordFromAcronym(acronym)
            .body()
            ?.firstOrNull()
            ?.lfs
            ?.map { it.lf }
            ?: emptyList()
    }
}
