package com.myapp.translatorapp.data.remote.dto

import com.myapp.translatorapp.domain.model.Translation

data class TranslationDto(
    val to: String,
    val translated: List<String>
) {
    fun toTranslation(): Translation {
        return Translation(to, translated)
    }
}