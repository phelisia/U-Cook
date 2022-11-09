package dev.phelisia.ucook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.phelisia.ucook.databinding.FragmentIngredientsBinding
import dev.phelisia.ucook.databinding.FragmentRatingsBinding


class RatingsFragment : Fragment() {
    private lateinit var binding:FragmentRatingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentRatingsBinding.inflate(inflater,container,false)
        return binding.root
    }

}