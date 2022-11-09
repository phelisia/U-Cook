package dev.phelisia.ucook.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.phelisia.ucook.*
import dev.phelisia.ucook.databinding.ActivityHomePageBinding
import dev.phelisia.ucook.fragments.ExploreFragment
import dev.phelisia.ucook.fragments.FavouriteFragment
import dev.phelisia.ucook.fragments.HomeFragment
import dev.phelisia.ucook.fragments.ProfileFragment

class HomePageActivity : AppCompatActivity() , ExploreListener {

    lateinit var binding :ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setBottomNav()
    }


    fun castViews(){
        binding.fcvHome
        binding.bnvhome
    }
    fun  setBottomNav(){
        binding.bnvhome.setOnItemSelectedListener{ item->
            when(item.itemId){
                R.id.home ->{ supportFragmentManager.beginTransaction().replace(
                    R.id.fcvHome,
                    HomeFragment()
                ).commit()
                    true
                }
                R.id.explore ->{
                    val transaction=supportFragmentManager.beginTransaction().replace(
                        R.id.fcvHome,
                        ExploreFragment()
                    ).commit()
                    true
                }
                R.id.favourite ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvHome,
                        FavouriteFragment()
                    ).commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.fcvHome,
                        ProfileFragment()
                    ).commit()
                    true
                }
                else->false
            }
        }
    }

    companion object{
        fun getIntent(context: Context): Intent {
            return  Intent(context, HomePageActivity::class.java)
        }

    }

    override fun onItemClicked(homeItem: HomeItem) {

        // createfound item activity here you use parceable
        startActivity(FoundItemActivity.getIntent(this, homeItem))

    }
}