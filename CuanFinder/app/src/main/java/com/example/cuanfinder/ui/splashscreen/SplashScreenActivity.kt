package com.example.cuanfinder.ui.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import com.example.cuanfinder.R
import com.example.cuanfinder.dashboard
import com.example.cuanfinder.signup
import com.example.cuanfinder.starting
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_splash)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler().postDelayed({
            if(user != null){
                val intent = Intent(this, dashboard::class.java)
                startActivity(intent)
                finish()
            }else{
                val signInIntent = Intent(this, starting::class.java)
                startActivity(signInIntent)
                finish()
            }
        },3000)
    }
}