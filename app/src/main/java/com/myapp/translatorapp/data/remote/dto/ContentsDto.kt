package com.myapp.translatorapp.data.remote.dto

import com.myapp.translatorapp.domain.model.Contents

data class ContentsDto(
    val text: String,
    val translated: String,
    val translation: String
) {
    fun toContents(): Contents {
        return Contents(translated, translation)
    }
}