package com.example.codingchallenge.view

/**
 * Acronym screen state.
 *
 * @property isLoading
 * @property response
 * @property showResultText
 * @property errorTextId
 * @constructor Create empty Acronym screen state
 */
data class AcronymScreenState(
    val isLoading: Boolean = false,
    val response: List<String> = emptyList(),
    val showResultText: Boolean = false,
    val errorTextId: Int? = null
)
