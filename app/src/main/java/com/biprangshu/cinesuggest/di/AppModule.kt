package com.biprangshu.cinesuggest.di

import android.app.Application
import com.biprangshu.cinesuggest.LocalUserManagerInpl
import com.biprangshu.cinesuggest.domain.usecases.AppEntryUseCases
import com.biprangshu.cinesuggest.domain.usecases.LocalUserManager
import com.biprangshu.cinesuggest.domain.usecases.ReadAppEntry
import com.biprangshu.cinesuggest.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager = LocalUserManagerInpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}