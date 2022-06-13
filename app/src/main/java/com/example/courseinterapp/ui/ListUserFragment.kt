package com.example.courseinterapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.courseinterapp.R
import com.example.courseinterapp.databinding.FragmentListUserBinding
import com.example.courseinterapp.ui.adapters.UserAdapter
import com.example.courseinterapp.ui.adapters.decorators.FeedVerticalDividerItemDecoration
import com.example.courseinterapp.ui.viewmodel.ListUserFragmentViewModel
import com.example.courseinterapp.ui.workers.MyWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class ListUserFragment : Fragment(R.layout.fragment_list_user) {

    private val binding: FragmentListUserBinding by viewBinding()
    private val viewModel: ListUserFragmentViewModel by viewModels()

    private val userAdapter: UserAdapter by lazy { UserAdapter() }

    private val navigateListener = View.OnClickListener {
        ListUserFragmentDirections.navToAddUserFragment().apply {
            findNavController().navigate(this)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getUsers()

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            userList.adapter = userAdapter
            userList.layoutManager = LinearLayoutManager(requireContext())
            floatButton.setOnClickListener(navigateListener)
        }
        // Установка значений
        lifecycleScope.launchWhenCreated {
            with(viewModel) {
                users.collect {
                    userAdapter.setList(it)
                }
            }
        }
        binding.userList.addItemDecoration(FeedVerticalDividerItemDecoration(16, userAdapter.itemCount))
//        cardAdapter.cardImageClickListener = {
//            simpleWork()
//        }
    }



    private fun simpleWork(){
        Log.d("MyWorker","simpleWork executing ")
        val constraint: Constraints = Constraints.Builder()
            .build()
        val request: PeriodicWorkRequest = PeriodicWorkRequestBuilder<MyWorker>(15, TimeUnit.MINUTES)
            .addTag("tag")
            .setConstraints(constraint)
            .setBackoffCriteria(BackoffPolicy.LINEAR, PeriodicWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(requireContext())
            .enqueueUniquePeriodicWork("work", ExistingPeriodicWorkPolicy.KEEP, request)
    }


    companion object {
        fun newInstance() = FragmentMembers()
    }
}