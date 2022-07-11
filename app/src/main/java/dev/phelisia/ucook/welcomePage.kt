package dev.phelisia.ucook

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import dev.phelisia.ucook.databinding.ActivityWelcomePageBinding

class welcomePage : AppCompatActivity() {
    lateinit var binding: ActivityWelcomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityWelcomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCreate.setOnClickListener {
            startActivity(ucookSignup.getIntent(this))

        }

    }
    companion object{
        fun getIntent(context: Context):Intent{
            return  Intent(context, welcomePage::class.java)
        }
    }
}