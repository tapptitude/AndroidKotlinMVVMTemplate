package com.tapptitude.template.session.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.tapptitude.template.session.model.LoggedIn
import com.tapptitude.template.session.model.LoggedOut
import com.tapptitude.template.session.model.LoginState
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

internal class LocalSessionDataManager(private val appContext: Context) {
    private val Context.sessionPreferences: DataStore<Preferences> by preferencesDataStore(SESSION_PREFERENCES_NAME)

    suspend fun loadLoginState(): LoginState {
        return appContext.sessionPreferences.data.map { storage -> storage.toLoginState() }.firstOrNull() ?: LoggedOut()
    }

    suspend fun updateLoginState(loggedIn: LoggedIn) {
        appContext.sessionPreferences.edit { storage ->
            storage[KEY_LOGGED_IN] = true
            storage[KEY_SESSION_TOKEN] = loggedIn.sessionToken
            storage[KEY_USER_ID] = loggedIn.userId
        }
    }

    suspend fun updateLoginState(loggedOut: LoggedOut) {
        appContext.sessionPreferences.edit { storage ->
            storage[KEY_LOGGED_IN] = false

            if (loggedOut.lastUserId.isNullOrEmpty()) {
                storage.remove(KEY_USER_ID)
            } else {
                storage[KEY_USER_ID] = loggedOut.lastUserId
            }

            storage.remove(KEY_SESSION_TOKEN)
        }
    }

    private fun Preferences.toLoginState(): LoginState {
        return if (this[KEY_LOGGED_IN] == true) {
            val sessionToken = this[KEY_SESSION_TOKEN] ?: return LoggedOut()
            val userId = this[KEY_USER_ID] ?: return LoggedOut()

            LoggedIn(sessionToken, userId)
        } else {
            val userId = this[KEY_USER_ID] ?: return LoggedOut()

            LoggedOut(lastUserId = userId)
        }
    }

    companion object {
        private const val SESSION_PREFERENCES_NAME = "session"

        private val KEY_LOGGED_IN = booleanPreferencesKey("KEY_LOGGED_IN")
        private val KEY_SESSION_TOKEN = stringPreferencesKey("KEY_SESSION_TOKEN")
        private val KEY_USER_ID = stringPreferencesKey("KEY_USER_ID")
    }
}
