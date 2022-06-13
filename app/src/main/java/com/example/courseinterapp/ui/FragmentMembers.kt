package com.example.courseinterapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.work.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.courseinterapp.R
import com.example.courseinterapp.data.model.Icon
import com.example.courseinterapp.data.model.Memory
import com.example.courseinterapp.databinding.FragmentMembersBinding
import com.example.courseinterapp.utils.Const.ACTION_START_OR_RESUME_SERVICE
import com.example.courseinterapp.ui.adapters.CardAdapter
import com.example.courseinterapp.ui.adapters.IconAdapter
import com.example.courseinterapp.ui.adapters.decorators.FeedHorizontalDividerItemDecoration
import com.example.courseinterapp.ui.adapters.decorators.FeedVerticalDividerItemDecoration
import com.example.courseinterapp.ui.services.TestService
import com.example.courseinterapp.ui.workers.MyWorker
import java.util.concurrent.TimeUnit

class FragmentMembers : Fragment(R.layout.fragment_members) {

    private val binding: FragmentMembersBinding by viewBinding()

    private val cardAdapter: CardAdapter by lazy { CardAdapter() }
    private val iconAdapter: IconAdapter by lazy { IconAdapter() }

//    private val cardImageClickListener = CardAdapter.CardImageClickListener{
//        simpleWork()
//    }
//
//    private val cardTitleCLickListener = CardAdapter.CardTitleClickListener {
//        sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
//    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        cardAdapter.cardImageClickListener = cardImageClickListener
//        cardAdapter.cardTitleClickListener = cardTitleCLickListener


        with(binding) {
            cardList.adapter = cardAdapter
            cardList.layoutManager = LinearLayoutManager(requireContext())
            iconList.adapter = iconAdapter
        }
        cardAdapter.setList(list)
        iconAdapter.setList(iconList)
        binding.cardList.addItemDecoration(FeedVerticalDividerItemDecoration(16, cardAdapter.itemCount))
        binding.iconList.addItemDecoration(FeedHorizontalDividerItemDecoration(16, iconAdapter.itemCount))
        cardAdapter.cardImageClickListener = {
            simpleWork()
        }
        cardAdapter.cardTitleCickListener = {
            sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
        }
    }


    private fun sendCommandToService(action:String) =
        Intent(requireContext(), TestService::class.java).also {
            it.action  = action
            requireContext().startService(it)
        }


    private fun simpleWork(){
        Log.d("MyWorker","simpleWork executing ")
        val constraint:Constraints = Constraints.Builder()
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

        private val iconList = listOf(
            Icon.Active(0, "zero"),
            Icon.Disable(1, "first"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
            Icon.Active(2, "second"),
            Icon.Disable(3, "third"),
        )

        private val list = listOf(
            Memory(0, "zero", "zero desc", ""),
            Memory(1, "first", "first desc", ""),
            Memory(2, "second", "second desc", ""),
            Memory(3, "third", "third desc", ""),
            Memory(4, "forth", "forth desc", ""),
            Memory(5, "fifth", "fifth desc", ""),
            Memory(6, "sixth", "sixth desc", ""),
            Memory(7, "seventh", "seventh desc", ""),
        )
    }
}