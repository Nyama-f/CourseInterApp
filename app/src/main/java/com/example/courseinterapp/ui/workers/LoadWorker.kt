package com.example.courseinterapp.ui.workers

import android.content.Context
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.*
import com.example.courseinterapp.R
import com.example.courseinterapp.data.model.UserApi
import com.example.courseinterapp.domain.useCases.AddUserUseCase
import com.example.courseinterapp.utils.Const
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.delay
import kotlin.random.Random

@HiltWorker
class LoadWorker @AssistedInject constructor(
    @Assisted
    private val context: Context,
    @Assisted
    workerParameters: WorkerParameters,
    private val addUserUseCase: AddUserUseCase
): CoroutineWorker(context, workerParameters) {

    override suspend fun doWork(): ListenableWorker.Result {
        return try {
            showNotification()
            delay(1000)
            val userName = inputData.getString("userName")
            val userEmail = inputData.getString("userEmail")
            val userImage = inputData.getString("imageID")
            if(userName != null && userEmail != null && userImage != null){
                addUserUseCase(
                    UserApi(
                        userImage = userImage,
                        userEmail = userEmail ,
                        userName = userName,
                        userId = null
                    ))
                Log.d("MyWorker", "Success work")
                ListenableWorker.Result.success()
            }else{
                Result.failure()
            }
        } catch (exception: Exception){
            Log.d("MyWorker", "Error on do work")
            ListenableWorker.Result.failure()
        }
    }

    private suspend  fun showNotification(){
        Log.d("MyWorker", "Show Notification")
        setForeground(
            ForegroundInfo(
                Random.nextInt(),
                NotificationCompat.Builder(context, Const.WORKER_CHANNEL_ID)
                    .setSmallIcon(R.drawable.burger)
                    .setContentText("Load Image")
                    .setContentTitle("I'm loading image")
                    .build()
            )
        )
    }
}