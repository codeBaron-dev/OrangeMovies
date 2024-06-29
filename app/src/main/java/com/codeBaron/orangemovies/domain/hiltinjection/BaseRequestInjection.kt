package com.codeBaron.orangemovies.domain.hiltinjection

import com.codeBaron.orangemovies.data.utils.ACCESS_TOKEN
import com.codeBaron.orangemovies.data.utils.BASE_URL
import com.codeBaron.orangemovies.domain.mvvm.MoviesRepository
import com.codeBaron.orangemovies.domain.remote.MoviesApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BaseRequestInjection {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        okhttp3.OkHttpClient.Builder().apply {
            readTimeout(60, TimeUnit.SECONDS)
            connectTimeout(60, TimeUnit.SECONDS)
            addInterceptor(loggingInterceptor).addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("accept", "application/json")
                    .addHeader("Authorization", ACCESS_TOKEN)
                    .build()
                chain.proceed(request)
            }
        }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: okhttp3.OkHttpClient) = retrofit2.Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        client(okHttpClient)
        addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
        build()
    }

    @Singleton
    @Provides
    fun providesMovieApi(retrofit: retrofit2.Retrofit) = retrofit.create(MoviesApi::class.java)

    @Singleton
    @Provides
    fun providesMovieRepository(moviesApi: MoviesApi) = MoviesRepository(moviesApi)
}