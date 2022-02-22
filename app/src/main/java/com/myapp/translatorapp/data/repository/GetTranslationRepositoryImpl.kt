package com.myapp.translatorapp.data.repository

import com.myapp.translatorapp.data.remote.TranslatorApi
import com.myapp.translatorapp.domain.model.TranslatedText
import com.myapp.translatorapp.domain.repository.GetTranslationRepository
import com.myapp.translatorapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTranslationRepositoryImpl @Inject constructor(
    private val api: TranslatorApi
): GetTranslationRepository {

    override fun getTranslation(text: String): Flow<Resource<TranslatedText>> = flow {

        emit(Resource.Loading<TranslatedText>())

        try {
            val response = api.getTextTranslation(text).toTranslatedText()
            emit(Resource.Success<TranslatedText>(data = response))
        } catch (e: HttpException){
            emit(Resource.Error<TranslatedText>(message = e.localizedMessage ?: "Unknown error"))
        } catch (e: IOException) {
            emit(Resource.Error<TranslatedText>(message = e.localizedMessage ?: "Unknown error"))
        }

    }
}