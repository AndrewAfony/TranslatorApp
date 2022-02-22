package com.myapp.translatorapp.data.remote.dto

data class TranslationDto(
    val to: String,
    val translated: List<String>
)