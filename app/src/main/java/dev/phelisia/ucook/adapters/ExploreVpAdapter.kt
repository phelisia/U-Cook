package dev.phelisia.ucook.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import dev.phelisia.ucook.fragments.AllFragment
import dev.phelisia.ucook.fragments.CategoryFragment
import dev.phelisia.ucook.fragments.CuisineFragment
import dev.phelisia.ucook.fragments.TimeFragment

class ExploreVpAdapter(fragmentmanger:FragmentManager, var tabTitles: List<String>) :FragmentPagerAdapter(fragmentmanger){
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        when (position){
            0-> return AllFragment()
            1-> return CuisineFragment()
            2-> return CategoryFragment()
            3-> return TimeFragment()
            else-> return AllFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }


}