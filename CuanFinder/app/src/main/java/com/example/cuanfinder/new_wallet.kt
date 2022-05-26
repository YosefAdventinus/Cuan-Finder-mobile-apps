package com.example.cuanfinder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class new_wallet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_wallet)

        val btn : ImageButton = findViewById(R.id.btnBack0);
        btn.setOnClickListener{
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent);
            finish()
        }

    }
}