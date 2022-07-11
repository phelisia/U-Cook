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
            val intent=Intent(this,ucookLogin::class.java)
            startActivity(intent)

        }
        binding.btnSignup.setOnClickListener {
            startActivity(homePage.getIntent(this))

        }

    }

    companion object{
        fun getIntent(context: Context):Intent{
            return  Intent(context, ucookSignup::class.java)
        }
    }


    }

