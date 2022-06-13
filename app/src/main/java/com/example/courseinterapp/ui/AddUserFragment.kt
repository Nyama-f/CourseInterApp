package com.example.courseinterapp.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.work.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.courseinterapp.R
import com.example.courseinterapp.databinding.FragmentAddUserBinding
import com.example.courseinterapp.ui.workers.LoadWorker
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class AddUserFragment : DialogFragment(R.layout.fragment_add_user) {
    private val binding: FragmentAddUserBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){

            saveButton.setOnClickListener {
                val data = Data.Builder()
                with(data) {
                    putString("imageID", R.drawable.audi_rs5.toString())
                    putString("userName", etName.text.toString())
                    putString("userEmail", etEmail.text.toString())
                }
                loadWork(data)
            }
        }
    }

    private fun loadWork(data: Data.Builder){
        Log.d("LoadWorker","LoadWork executing ")
        val constraint: Constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .build()
        val request: OneTimeWorkRequest = OneTimeWorkRequestBuilder<LoadWorker>()
            .addTag("tag")
            .setInputData(data.build())
            .setConstraints(constraint)
            .setBackoffCriteria(BackoffPolicy.LINEAR, PeriodicWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)
            .build()

        WorkManager.getInstance(requireContext())
            .enqueueUniqueWork("LoadWork", ExistingWorkPolicy.KEEP, request)
    }
}