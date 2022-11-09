package dev.phelisia.ucook.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.phelisia.ucook.databinding.FragmentIngredientsBinding
import dev.phelisia.ucook.databinding.FragmentProcedureBinding

class ProcedureFragment : Fragment() {
    private lateinit var binding : FragmentProcedureBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            binding=FragmentProcedureBinding.inflate(inflater,container,false)
            return binding.root
        }

    }
