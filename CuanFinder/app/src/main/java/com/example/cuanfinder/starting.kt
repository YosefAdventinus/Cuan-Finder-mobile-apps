package com.example.cuanfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class starting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_start)

        val btn: Button = findViewById(R.id.btnStart);
        btn.setOnClickListener {
            val intent = Intent(this, signup::class.java)
            startActivity(intent);
        }

    }
}