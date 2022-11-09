package dev.phelisia.ucook.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import dev.phelisia.ucook.adapters.ViewPagerAdapter
import dev.phelisia.ucook.databinding.ActivityIngredientsBinding
import kotlinx.android.synthetic.main.activity_ingredients.*

class IngredientsActivity : AppCompatActivity() {
    lateinit var binding: ActivityIngredientsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityIngredientsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
binding.toolbar.title="Ingredients"
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        view_pager.adapter = adapter

        TabLayoutMediator(tabLayout, view_pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Ingredients"
                }
                1 -> {
                    tab.text = "Pro"
                }
                2 -> {
                    tab.text = "Ratings"
                }

            }
        }.attach()

    }
    companion object{
        fun getIntent(context: Context): Intent {
            return  Intent(context, IngredientsActivity::class.java)
        }
    }
}