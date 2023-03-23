package com.example.codingchallenge.model.dto

@kotlinx.serialization.Serializable
data class Lf(
    val freq: Int,
    val lf: String,
    val since: Int,
    val vars: List<Var>
)
