package com.tapptitude.template.network.factory

import com.squareup.moshi.Moshi
import com.tapptitude.template.config.AppConfig
import com.tapptitude.template.network.interceptor.SessionInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal object NetworkComponentsFactory {
    fun provideOkHttpClient(sessionInterceptor: SessionInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(sessionInterceptor)

            if (AppConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                addInterceptor(loggingInterceptor)
            }
        }.build()
    }

    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    fun <ApiImpl> provideApiImplementation(
        retrofit: Retrofit,
        apiClass: Class<ApiImpl>,
    ): ApiImpl {
        return retrofit.create(apiClass)
    }
}
