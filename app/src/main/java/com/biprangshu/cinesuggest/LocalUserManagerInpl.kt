package com.biprangshu.cinesuggest

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.biprangshu.cinesuggest.domain.usecases.LocalUserManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserManagerInpl (
    private val context: Context
): LocalUserManager{
    override suspend fun SaveAppEntry() {
        context.dataStore.edit {
            settings->
            settings[PreferencesKeys.APP_ENTRY]= true
        }

    }
    override fun ReadAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map{
            settings->
            settings[PreferencesKeys.APP_ENTRY]?: false
        }
    }

}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "userSettings")

private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = "appEntry")
}