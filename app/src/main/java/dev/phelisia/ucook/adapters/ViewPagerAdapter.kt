package dev.phelisia.ucook.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.phelisia.ucook.fragments.IngredientsFragment
import dev.phelisia.ucook.fragments.ProcedureFragment
import dev.phelisia.ucook.fragments.RatingsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                IngredientsFragment()
            }
            1->{
                ProcedureFragment()
            }
            2->{
                RatingsFragment()
            }
            else->{
                Fragment()
            }
        }
    }
}