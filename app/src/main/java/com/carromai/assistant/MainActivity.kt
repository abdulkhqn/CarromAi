package com.carromai.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.carromai.assistant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var prefs: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = PreferencesManager(this)
        binding.btnBlack.setOnClickListener { select(PlayerColor.BLACK) }
        binding.btnWhite.setOnClickListener { select(PlayerColor.WHITE) }
        render(prefs.getPlayerColor())
    }

    private fun select(color: PlayerColor) {
        prefs.setPlayerColor(color)
        render(color)
    }

    private fun render(color: PlayerColor?) {
        binding.tvStatus.setText(
            when (color) {
                PlayerColor.BLACK -> R.string.status_black
                PlayerColor.WHITE -> R.string.status_white
                null -> R.string.status_none
            }
        )
        binding.btnBlack.alpha = if (color == null || color == PlayerColor.BLACK) 1f else 0.5f
        binding.btnWhite.alpha = if (color == null || color == PlayerColor.WHITE) 1f else 0.5f
    }
}
