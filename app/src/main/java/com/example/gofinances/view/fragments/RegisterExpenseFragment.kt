package com.example.gofinances.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gofinances.databinding.FragmentRegisterExpenseBinding

class RegisterExpenseFragment : Fragment() {
    private lateinit var binding: FragmentRegisterExpenseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterExpenseBinding.inflate(inflater, container, false)

        binding.buttonIncome.setOnClickListener {
            if (!binding.buttonIncome.STATE_CLICK) {
                binding.buttonIncome.setClickState()
            } else {
                binding.buttonIncome.setNormalState()
            }
        }

        return binding.root
    }
}