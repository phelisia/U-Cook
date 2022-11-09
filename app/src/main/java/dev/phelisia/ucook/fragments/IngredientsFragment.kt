package dev.phelisia.ucook.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dev.phelisia.ucook.databinding.FragmentIngredientsBinding
import kotlinx.android.synthetic.main.fragment_ingredients.*


class IngredientsFragment : Fragment() {
    private lateinit var binding : FragmentIngredientsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentIngredientsBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCheckedChangedListener()


    }


    private fun setCheckedChangedListener() {
        val checkedboxes= listOf( cbOne,cbTwo,cbThree,cbFour,cbFive,cbSix,cbSeven,cbEight,cbNine,cbTen)


        }
    }









