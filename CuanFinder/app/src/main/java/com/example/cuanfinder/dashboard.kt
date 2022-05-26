package com.example.cuanfinder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.FirebaseAuth

class dashboard: AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_dashboard)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        mAuth = FirebaseAuth.getInstance()

        val logout = findViewById<Button>(R.id.logoutsementara) as Button
        logout.setOnClickListener {
            mAuth.signOut()
            val intent = Intent(this, signup::class.java)
            startActivity(intent)
            finish()
        }

        val btn1: Button = findViewById(R.id.btnSearch);
        btn1.setOnClickListener {
            val intent = Intent(this, search::class.java)
            startActivity(intent)
            finish()
        }

        val btn2: Button = findViewById(R.id.appCompatButton80);
        btn2.setOnClickListener {
            val intent = Intent(this, messages::class.java)
            startActivity(intent)
            finish()
        }

        val btn3: Button = findViewById(R.id.appCompatButton90);
        btn3.setOnClickListener {
            val intent = Intent(this, project::class.java)
            startActivity(intent)
            finish()
        }

        val btn4: Button = findViewById(R.id.btnSeeButt);
        btn4.setOnClickListener {
            val intent = Intent(this, new_wallet::class.java)
            startActivity(intent)
            finish()
        }
    }
}