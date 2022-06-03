package com.example.courseinterapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.courseinterapp.R
//import com.example.courseinterapp.databinding.FragmentFirstGraphBinding

class FirstGraphFragment : Fragment() {

    // Коммент оставлен чтобы была возможность отправить коммит
//
//    private var _binding: FragmentFirstGraphBinding? = null
//    private val binding get() = checkNotNull(_binding) { "Binding is null" }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        _binding = FragmentFirstGraphBinding.inflate(inflater, container, false)
//        return binding.root
//
//
//    }
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val imgButton: ImageButton = binding.imgButton
//        val editText = binding.editText
//        val bundle = Bundle()
//
//        imgButton.setOnClickListener{
//            val name = editText.text
//            val hello = "Hello, ${name}"
////            bundle.putString("MyArg", hello)
////            findNavController().navigate(R.id.secondGraphFragment, bundle)
//
//            val action = FirstGraphFragmentDirections.actionFirstGraphFragmentToSecondGraphFragment()
//            action.setMyArg(hello)
//            findNavController().navigate(action)
//        }
//    }
//

}