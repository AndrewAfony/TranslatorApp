package com.myapp.translatorapp.domain.repository

import com.myapp.translatorapp.domain.model.Translation
import com.myapp.translatorapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetTranslationRepository {

    suspend fun getTranslation(text: String, langFrom: String, langTo: String): Flow<Resource<Translation>>

}