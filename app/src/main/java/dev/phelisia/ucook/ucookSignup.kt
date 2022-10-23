package dev.phelisia.ucook

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.phelisia.ucook.databinding.ActivityUcookSignupBinding

class ucookSignup : AppCompatActivity() {
    lateinit var binding: ActivityUcookSignupBinding
    private var isNameValid = false
    private var isEmailValid = false
    private var isPasswordValid = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUcookSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, ucookLogin::class.java))
        }

        binding.btnSignup.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        validateSignup()

        if (isValidSignUp()) {
            goToHomepage()
        }
    }

    private fun validateSignup() {
        validateName()
        validateEmail()
        validatePassword()
    }

    /**
     * Validate the first and second name
     */
    private fun validateName() {
        val name = binding.etUser.text.toString()


        isNameValid = name.isBlank().not()

        if (name.isBlank()) {
            binding.tilUser.error = "First name required"
        } else {
            binding.tilUser.error = null
        }


    }

    /**
     * Validate the email address
     */
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
        val confirm = binding.etConfirm.text.toString()
        val password = binding.etPassword.text.toString()

        if (confirm.isBlank()) {
            binding.tilConfirm.error = "confirm password"
        } else {
            binding.tilConfirm.error = null
        }

        if (password.isBlank()) {
            binding.tilPassword.error = "enter password"
        } else {
            binding.tilPassword.error = null
        }

        if (confirm == password && confirm.isBlank().not() && password.isBlank().not()) {
            binding.tilConfirm.error = null
            isPasswordValid = true
        } else {
            isPasswordValid = false
            binding.tilConfirm.error = "invalid"
        }
    }

    private fun isValidSignUp(): Boolean {
        return isNameValid && isEmailValid && isPasswordValid
    }

    private fun goToHomepage() {
        startActivity(Intent(this, HomePageActivity::class.java))
    }

    companion object{
        fun getIntent(context: Context):Intent{
            return  Intent(context, ucookSignup::class.java)
        }
    }


    }

