package com.biprangshu.cinesuggest.domain.usecases

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    suspend fun SaveAppEntry()

    fun ReadAppEntry(): Flow<Boolean>
}