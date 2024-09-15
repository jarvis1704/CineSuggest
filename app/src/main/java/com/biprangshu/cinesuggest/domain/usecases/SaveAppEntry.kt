package com.biprangshu.cinesuggest.domain.usecases

import kotlinx.coroutines.flow.Flow

class SaveAppEntry(
    private val localUserManager: LocalUserManager
){
    suspend operator fun invoke(){
        localUserManager.SaveAppEntry()
    }

}