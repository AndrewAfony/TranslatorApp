package com.myapp.translatorapp.data.remote

import com.myapp.translatorapp.data.remote.dto.TranslatedTextDto
import retrofit2.http.POST
import retrofit2.http.Query

interface TranslatorApi {

    @POST("translate/yoda.json")
    suspend fun getTextTranslation(
        @Query("text") text: String
    ): TranslatedTextDto

}