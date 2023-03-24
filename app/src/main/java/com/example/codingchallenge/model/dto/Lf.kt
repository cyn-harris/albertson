package com.example.codingchallenge.model.dto

@kotlinx.serialization.Serializable
data class Lf(
    val freq: Int = 0,
    val lf: String = "",
    val since: Int = 0,
    val vars: List<Var> = emptyList()
)
