package com.example.courseinterapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.courseinterapp.R
import com.example.courseinterapp.databinding.FragmentAddUserBinding
import com.example.courseinterapp.databinding.FragmentListUserBinding
import com.example.courseinterapp.ui.viewmodel.AddUserFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddUserFragment : DialogFragment(R.layout.fragment_add_user) {
    private val binding: FragmentAddUserBinding by viewBinding()

    private val viewModel: AddUserFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            saveButton.setOnClickListener {
                viewModel.addUser(etName.text.toString(), etEmail.text.toString())
            }
        }
    }
}