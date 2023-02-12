package com.android.erwin.challenge5gamesuit.startup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.android.erwin.challenge5gamesuit.databinding.ActivitySplashScreenBinding
import com.android.erwin.challenge5gamesuit.loadImage

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()

        val url = "https://i.ibb.co/HC5ZPgD/splash-screen1.png"
        binding.imgLogo1.loadImage(url)

        val delaySplash = 3000L
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LandingPageActivity::class.java)
            startActivity(intent)
            finish()
        }, delaySplash)

    }
    companion object

}