package com.myapp.translatorapp.presentation

import com.myapp.translatorapp.domain.model.TranslatedText

data class TranslationState(
    val text: TranslatedText? = null,
    val isLoading: Boolean = false
)
