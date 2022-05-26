package com.example.cuanfinder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class search: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_search)

        val btn1 : Button = findViewById(R.id.appCompatButton60);
        btn1.setOnClickListener {
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent);
            finish()
        }
        val btn2 : Button = findViewById(R.id.appCompatButton80);
        btn2.setOnClickListener {
            val intent = Intent(this, messages::class.java)
            startActivity(intent);
            finish()
        }

    }
}