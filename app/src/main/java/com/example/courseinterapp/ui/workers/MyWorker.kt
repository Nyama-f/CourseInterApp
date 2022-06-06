package com.example.courseinterapp.ui.workers

import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.ForegroundInfo
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.courseinterapp.R
import com.example.courseinterapp.ui.Const.WORKER_CHANNEL_ID
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyWorker(
    private val context: Context,
    workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): Result{
        return try {
            showNotification()
            Log.d("MyWorker", "Success work")
            Result.success()
        } catch (exception: Exception){
            Log.d("MyWorker", "Error on do work")
            Result.failure()
        }
    }

    private suspend  fun showNotification(){
        Log.d("MyWorker", "Show Notification")
        setForeground(
            ForegroundInfo(
                Random.nextInt(),
                NotificationCompat.Builder(context, WORKER_CHANNEL_ID)
                    .setSmallIcon(R.drawable.burger)
                    .setContentText("Worker work")
                    .setContentTitle("My first worker")
                    .build()
            )
        )
    }
}
