package com.myapp.translatorapp.domain.repository

import com.myapp.translatorapp.domain.model.TranslatedText
import com.myapp.translatorapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetTranslationRepository {

    fun getTranslation(text: String): Flow<Resource<TranslatedText>>

}