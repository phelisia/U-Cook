package dev.phelisia.ucook.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.phelisia.ucook.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent()
        startActivity(intent)
        startActivity(ucookSignup.getIntent(this))
    }

    private fun intent(): Intent {
        return Intent(this, ucookSignup::class.java)

    }

}