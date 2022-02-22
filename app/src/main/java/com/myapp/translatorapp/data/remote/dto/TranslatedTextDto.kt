package com.myapp.translatorapp.data.remote.dto

import com.myapp.translatorapp.domain.model.TranslatedText

data class TranslatedTextDto(
    val contents: ContentsDto,
    val success: Success
) {
    fun toTranslatedText(): TranslatedText {
        return TranslatedText(contents.toContents())
    }
}