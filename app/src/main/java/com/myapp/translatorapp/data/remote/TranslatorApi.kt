package com.myapp.translatorapp.data.remote

import com.myapp.translatorapp.BuildConfig
import com.myapp.translatorapp.data.remote.dto.TranslateResultDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface TranslatorApi {

    @Headers(
        "X-API-Key: ${BuildConfig.TOKEN}",
        "Content-Type: application/json",
        "Accept: application/json"
    )
    @GET("v1/translate/text")
    suspend fun getTextTranslation(
        @Query("text") text: String,
        @Query("from") langFrom: String,
        @Query("to") langTo: String
    ): TranslateResultDto

}