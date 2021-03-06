package com.br.equipe.oito.presente.api.cep

import com.br.equipe.oito.presente.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {

    @GET("$BASE_URL{cep}/$CONTENT_TYPE")
    suspend fun getCepDetails(@Path("cep") cep: String): Response<Cep>

    companion object {

        private const val BASE_URL = "https://viacep.com.br/ws/"
        private const val CONTENT_TYPE = "json/"

        fun create(): CepService {
            var client: OkHttpClient? = null
            if (BuildConfig.DEBUG) {
                val logger =
                    HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
            }

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client ?: OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CepService::class.java)
        }

    }

}