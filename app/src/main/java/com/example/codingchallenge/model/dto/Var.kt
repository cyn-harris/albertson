package com.example.codingchallenge.model.dto

@kotlinx.serialization.Serializable
data class Var(
    val freq: Int,
    val lf: String,
    val since: Int
)
