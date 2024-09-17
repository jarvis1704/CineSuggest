package com.biprangshu.cinesuggest.di

import android.app.Application
import androidx.room.Room
import com.biprangshu.cinesuggest.data.local.MovieDatabase
import com.biprangshu.cinesuggest.data.remote.MovieApi
import com.biprangshu.cinesuggest.domain.usecases.AppEntryUseCases
import com.biprangshu.cinesuggest.domain.usecases.LocalUserManager
import com.biprangshu.cinesuggest.domain.usecases.ReadAppEntry
import com.biprangshu.cinesuggest.domain.usecases.SaveAppEntry
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
object AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun providesMovieApi() : MovieApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MovieApi.BASE_URL)
            .client(client)
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieDatabase(app: Application): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "moviedb.db"
        ).build()
    }

}