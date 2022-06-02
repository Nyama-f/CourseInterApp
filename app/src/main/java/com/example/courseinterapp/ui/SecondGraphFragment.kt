package com.example.courseinterapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.courseinterapp.R
import com.example.courseinterapp.databinding.FragmentFirstGraphBinding
import com.example.courseinterapp.databinding.FragmentSecondGraphBinding


class SecondGraphFragment : Fragment() {

    private var _binding: FragmentSecondGraphBinding? = null
    private val binding get() = checkNotNull(_binding) { "Binding is null" }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondGraphBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = binding.tvFragmentTwo
        val text = arguments?.getString("MyArg")
        textView.text = text
    }


}