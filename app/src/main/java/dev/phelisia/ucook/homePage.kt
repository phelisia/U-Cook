package dev.phelisia.ucook

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class homePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
    }




    companion object{
        fun getIntent(context: Context): Intent {
            return  Intent(context, homePage::class.java)
        }

    }
}