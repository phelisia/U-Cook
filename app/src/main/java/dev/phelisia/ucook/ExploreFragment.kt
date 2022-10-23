package dev.phelisia.ucook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TableLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import dev.phelisia.ucook.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {
    private lateinit var binding: FragmentExploreBinding
    private lateinit var viewPager: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titles = listOf("All", "Cuisine", "Category","Time")
        val viewpagerAdapter = ExploreVpAdapter(childFragmentManager, titles)
        binding.pager.adapter = viewpagerAdapter
        binding.tabLayout.addTab(binding.tabLayout.newTab(), 0)
        binding.tabLayout.addTab(binding.tabLayout.newTab(), 1)
        binding.tabLayout.addTab(binding.tabLayout.newTab(), 2)
        binding.tabLayout.addTab(binding.tabLayout.newTab(), 3)

        binding.tabLayout.setupWithViewPager(binding.pager)

    }








    companion object {

    }
}