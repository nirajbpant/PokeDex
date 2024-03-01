package com.example.pokedex.di

import android.content.Context
import com.example.pokedex.core.constants.API_ENDPOINT
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val interceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    internal fun providesGson() = GsonBuilder().setPrettyPrinting().create()

    //    @Provides
    //    @Singleton
    //    fun provideConnectivityInterceptor(context: Context): ConnectivityInterceptor {
    //        return ConnectivityInterceptor(context)
    //    }


    @Provides
    @Singleton
    internal fun providesOkHttpClient(
        gson: Gson,
        context: Context
    ): OkHttpClient = OkHttpClient.Builder().apply {
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder().baseUrl(API_ENDPOINT).client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
}
