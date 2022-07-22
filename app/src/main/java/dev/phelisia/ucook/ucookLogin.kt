package dev.phelisia.ucook

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.phelisia.ucook.databinding.ActivityHomePageBinding
import dev.phelisia.ucook.databinding.ActivityOnboardingBinding
import dev.phelisia.ucook.databinding.ActivityUcookLoginBinding
import dev.phelisia.ucook.databinding.ActivityUcookSignupBinding

class ucookLogin : AppCompatActivity() {
    lateinit var binding: ActivityUcookLoginBinding
    private var isPasswordValid= false
    private var isEmailValid = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUcookLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            login()
            finish()

        }

        binding.tvsign.setOnClickListener {

            startActivity(ucookSignup.getIntent(this))
        }


    }

    private fun login() {
        validateSignup()

        if (isValidSignUp()) {
            goToHomepage()
        }
    }

    private fun validateSignup() {
        validateEmail()
        validatePassword()
    }


    private fun validateEmail() {
        if (binding.etEmail.text.toString().isBlank()) {
            binding.tilEmail.error = "invalid email"
            isEmailValid = false
        } else {
            binding.tilEmail.error = null
            isEmailValid = true
        }
    }

    /**
     * Validate the password
     */
    private fun validatePassword() {

        val password = binding.etPassword.text.toString()

        if (password.isBlank()) {
            binding.tilPassword.error = "enter password"
        } else {
            binding.tilPassword.error = null
        }

        if ( password .isBlank().not() ) {
            binding.tilPassword.error = null
            isPasswordValid = true
        } else {
            isPasswordValid = false
            binding.tilPassword.error = "invalid"
        }
    }

    private fun isValidSignUp(): Boolean {
        return  isEmailValid && isPasswordValid
    }

    private fun goToHomepage() {
        startActivity(homePage.getIntent(this))
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, ucookLogin::class.java)
        }

    }
}