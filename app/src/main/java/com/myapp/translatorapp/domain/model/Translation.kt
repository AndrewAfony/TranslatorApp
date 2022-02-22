package com.myapp.translatorapp.domain.model

data class Translation(
    val to: String,
    val translated: List<String>
)