package com.carromai.assistant

import android.content.Context

enum class PlayerColor { BLACK, WHITE }

class PreferencesManager(context: Context) {

    private val prefs = context.applicationContext
        .getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getPlayerColor(): PlayerColor? =
        prefs.getString(KEY_COLOR, null)?.let { stored ->
            runCatching { PlayerColor.valueOf(stored) }.getOrNull()
        }

    fun setPlayerColor(color: PlayerColor) {
        prefs.edit().putString(KEY_COLOR, color.name).apply()
    }

    private companion object {
        const val PREFS_NAME = "carrom_prefs"
        const val KEY_COLOR = "player_color"
    }
}
