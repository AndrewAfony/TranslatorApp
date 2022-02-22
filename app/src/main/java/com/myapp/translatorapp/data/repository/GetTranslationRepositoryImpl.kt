package com.myapp.translatorapp.data.repository

import com.myapp.translatorapp.data.remote.TranslatorApi
import com.myapp.translatorapp.domain.model.Translation
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

    override suspend fun getTranslation(text: String, langFrom: String, langTo: String): Flow<Resource<Translation>> = flow {

        emit(Resource.Loading<Translation>())

        try {
            val response = api.getTextTranslation(text, langFrom, langTo).toTranslation()
            emit(Resource.Success<Translation>(data = response))
        } catch (e: HttpException){
            emit(Resource.Error<Translation>(message = e.localizedMessage ?: "Unknown error"))
        } catch (e: IOException) {
            emit(Resource.Error<Translation>(message = e.localizedMessage ?: "Unknown error"))
        }

    }
}