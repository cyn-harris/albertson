package com.example.codingchallenge.model.dto

@kotlinx.serialization.Serializable
data class ShortForResponseItem(
    val lfs: List<Lf>,
    val sf: String
)
