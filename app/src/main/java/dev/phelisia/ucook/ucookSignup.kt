package dev.phelisia.ucook

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.phelisia.ucook.databinding.ActivityUcookSignupBinding

class ucookSignup : AppCompatActivity() {
    lateinit var binding: ActivityUcookSignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUcookSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLogin.setOnClickListener {
            startActivity(homePage.getIntent(this))

        }

        binding.btnSignup.setOnClickListener {
            validateSignup()
            startActivity(homePage.getIntent(this))

        }


    }
    fun validateSignup(){
        var name=binding.etUser.text.toString()
        var email=binding.etEmail.text.toString()
        if (name.isBlank()){
            binding.tilUser.error="user name required"
        }
        if (email.isBlank()){
            binding.tilEmail.error="email required"

        }


        var confirm=binding.etConfirm.text.toString()
        var password=binding.etPassword.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "confirm password"
        } else {
            binding.tilConfirm.error = null
        }
        if (password.isBlank()){
            binding.tilPassword.error="enter password"
        }
        if (confirm==password){
            binding.btnSignup
        }
        else{
            binding.tilConfirm.error = "invalid password"
        }
    }

    companion object{
        fun getIntent(context: Context):Intent{
            return  Intent(context, ucookSignup::class.java)
        }
    }


    }

