package dev.phelisia.ucook

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ExploreVpAdapter(fragmentmanger:FragmentManager) :FragmentPagerAdapter(fragmentmanger){
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position){
            0-> return CuisineFragment()
            1-> return CategoryFragment()
            2-> return TimeFragment()
            else-> return CuisineFragment()

        }


    }




}