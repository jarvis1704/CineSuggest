package com.biprangshu.cinesuggest.domain.usecases

import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.ReadAppEntry()
    }

}