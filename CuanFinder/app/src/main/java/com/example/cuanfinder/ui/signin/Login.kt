package com.example.cuanfinder.ui.signin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.cuanfinder.R
import com.example.cuanfinder.dashboard
import com.example.cuanfinder.databinding.FragmentLoginBinding
import com.example.cuanfinder.register
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private var auth: FirebaseAuth? = null
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val btnDaftar = findViewById<Button>(R.id.btnDaftarBr)
        btnDaftar.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent);
        }

        binding.btnSignIn.setOnClickListener {
            val email = binding.Email.text.toString().trim { it <= ' ' }
            val password = binding.Password.text.toString().trim { it <= ' ' }
            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) ){
                Toast.makeText(applicationContext, "Field tidak boleh kosong !", Toast.LENGTH_SHORT).show()
            }
            //authenticate user
            auth!!.signInWithEmailAndPassword(email, password).addOnCompleteListener(this@Login) { task ->
                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful) {
                    Toast.makeText(applicationContext, "Terjadi Kesalahan !", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val intent = Intent(this@Login, dashboard::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}

