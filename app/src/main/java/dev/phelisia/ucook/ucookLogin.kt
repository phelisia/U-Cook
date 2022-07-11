package dev.phelisia.ucook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.phelisia.ucook.databinding.ActivityHomePageBinding
import dev.phelisia.ucook.databinding.ActivityOnboardingBinding
import dev.phelisia.ucook.databinding.ActivityUcookLoginBinding
import dev.phelisia.ucook.databinding.ActivityUcookSignupBinding

class ucookLogin : AppCompatActivity() {
    lateinit var binding: ActivityUcookLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUcookLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            validateLogin()
            finish()

        }
        binding.tvsign.setOnClickListener {

            startActivity(ucookSignup.getIntent(this))
        }
    }

    private fun validateLogin() {
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var error = false
        if (email.isBlank()) {
            binding.tilEmail.error = "Email required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "password required"
            error = true
        }

        if (!error) {
            startActivity(Intent(this, homePage::class.java))


        }

    }

}