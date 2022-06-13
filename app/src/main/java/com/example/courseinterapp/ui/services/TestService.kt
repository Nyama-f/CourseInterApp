package com.example.courseinterapp.ui.services

import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.example.courseinterapp.MainActivity
import com.example.courseinterapp.R
import com.example.courseinterapp.utils.Const
import com.example.courseinterapp.utils.Const.ACTION_OPEN_SECOND_FRAGMENT
import com.example.courseinterapp.utils.Const.ACTION_PAUSE_SERVICE
import com.example.courseinterapp.utils.Const.ACTION_START_OR_RESUME_SERVICE
import com.example.courseinterapp.utils.Const.ACTION_STOP_SERVICE
import com.example.courseinterapp.utils.Const.SERVICE_NOTIFICATION_ID


class TestService : LifecycleService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when (it.action) {
                ACTION_START_OR_RESUME_SERVICE -> {
                    startForegroundService()
                    Log.e("MyService", "Start or resume")
                }
                ACTION_PAUSE_SERVICE -> {

                    Log.e("MyService", "Pause")
                }
                ACTION_STOP_SERVICE -> {
                    stopForeground(true)
                    Log.e("MyService", "Stop")
                }
                else -> {}
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun getMainActivityPendingIntent() =
        PendingIntent.getActivity(
            this,
            0,
            Intent(this, MainActivity::class.java).also {
                it.action = ACTION_OPEN_SECOND_FRAGMENT
            },
            FLAG_UPDATE_CURRENT or FLAG_IMMUTABLE
        )

    private fun startForegroundService() {
        NotificationCompat.Builder(this, Const.SERVICE_CHANNEL_ID)
            .setSmallIcon(R.drawable.burger)
            .setContentText("Service work")
            .setContentTitle("My first foreground service")
            .setContentIntent(getMainActivityPendingIntent())
            .build()
            .also {
                startForeground(SERVICE_NOTIFICATION_ID, it)
            }
    }
}