package com.example.cuanfinder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.cuanfinder.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class register : AppCompatActivity() {

    private var auth: FirebaseAuth? = null
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_register)
        supportActionBar?.hide()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnSignUp1.setOnClickListener {

            val email = binding.editText.text.toString().trim { it <= ' ' }
            val password = binding.editText00.text.toString().trim { it <= ' ' }
            val cpassword = binding.editText100.text.toString().trim { it <= ' ' }

            if(password != cpassword){
                Toast.makeText(applicationContext, "Password harus sama !", Toast.LENGTH_SHORT).show()
            }
            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(cpassword) ){
                Toast.makeText(applicationContext, "Field tidak boleh kosong !", Toast.LENGTH_SHORT).show()
            }
            //create user
            auth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this@register) { task ->
                Toast.makeText(this@register,"Behasil membuat akun!" + task.isSuccessful, Toast.LENGTH_SHORT).show()
                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful) {
                    Toast.makeText(this@register, "Authentication failed." + task.exception,Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(Intent(this@register, dashboard::class.java))
                    finish()
                }
            }
        }
    }
}