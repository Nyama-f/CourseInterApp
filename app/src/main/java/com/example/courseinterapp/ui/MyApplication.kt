
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.courseinterapp.ui.Const.SERVICE_CHANNEL_ID
import com.example.courseinterapp.ui.Const.WORKER_CHANNEL_ID

class MyApplication: Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(){
        val workerChannel = NotificationChannel(
            WORKER_CHANNEL_ID,
            "Worker channel",
            NotificationManager.IMPORTANCE_HIGH
        )
        val serviceChannel = NotificationChannel(
            SERVICE_CHANNEL_ID,
            "SERVICE Channel",
            NotificationManager.IMPORTANCE_HIGH
        )


        val notificationManager = getSystemService(NotificationManager::class.java)
        with(notificationManager){
            createNotificationChannel(workerChannel)
            createNotificationChannel(serviceChannel)
        }
    }
}
