package com.example.courseinterapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.courseinterapp.R
import com.example.courseinterapp.data.model.Icon
import com.example.courseinterapp.data.model.Memory
import com.example.courseinterapp.databinding.FragmentListUserBinding
import com.example.courseinterapp.databinding.FragmentMembersBinding
import com.example.courseinterapp.ui.adapters.CardAdapter
import com.example.courseinterapp.ui.adapters.IconAdapter
import com.example.courseinterapp.ui.adapters.UserAdapter
import com.example.courseinterapp.ui.adapters.decorators.FeedHorizontalDividerItemDecoration
import com.example.courseinterapp.ui.adapters.decorators.FeedVerticalDividerItemDecoration
import com.example.courseinterapp.ui.services.TestService
import com.example.courseinterapp.ui.workers.MyWorker
import com.example.courseinterapp.utils.Const
import java.util.concurrent.TimeUnit

class ListUserFragment : Fragment(R.layout.fragment_list_user) {

    private val binding: FragmentListUserBinding by viewBinding()

    private val userdapter: UserAdapter by lazy { UserAdapter() }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            userList.adapter = userdapter
            userList.layoutManager = LinearLayoutManager(requireContext())
        }
        //cardAdapter.setList(list)
        binding.userList.addItemDecoration(FeedVerticalDividerItemDecoration(16, userdapter.itemCount))
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