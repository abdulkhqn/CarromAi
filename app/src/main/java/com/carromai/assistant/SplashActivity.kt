package com.carromai.assistant

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())
    private val openMain = Runnable {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler.postDelayed(openMain, SPLASH_DELAY_MS)
    }

    override fun onDestroy() {
        handler.removeCallbacks(openMain)
        super.onDestroy()
    }

    private companion object {
        const val SPLASH_DELAY_MS = 1200L
    }
}
