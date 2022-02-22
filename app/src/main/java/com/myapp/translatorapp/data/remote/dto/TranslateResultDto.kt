package com.myapp.translatorapp.data.remote.dto

data class TranslateResultDto(
    val from: String,
    val translated_characters: Int,
    val translations: List<TranslationDto>
)