package dnt.kotlin.bai1_basicandroid.service

import android.annotation.SuppressLint
import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import androidx.core.app.NotificationCompat
import dnt.kotlin.bai1_basicandroid.R

class MusicForegroundService : Service() {

    private lateinit var mediaPlayer: MediaPlayer
    private val CHANNEL_ID = "MusicForegroundChannel"

    override fun onCreate() {
        super.onCreate()

        //---   Khởi tạo MediaPlayer    ---
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.isLooping = true
    }

    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.action

        if (action == "STOP") {
            stopForeground(true)
            stopSelf()
            return START_NOT_STICKY
        }

        val notification = createNotification()

        //---   Bắt đầu dịch vụ ở chế độ Foreground     ---
        startForeground(1, notification)

        mediaPlayer.start() //->    Phát nhạc

        return START_STICKY
    }

    //===   Dừng nhạc và giải phóng tài nguyên   ===
    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    //===   Tạo thông báo   ===
    private fun createNotification(): Notification {
        //---   Tạo Notification Channel    ---
        createNotificationChannel()

        //---   Tạo intent để dừng dịch vụ   ---
        val stopIntent = Intent(this, MusicForegroundService::class.java).apply {
            this.action = "STOP"
        }

        val stopPendingIntent = PendingIntent.getService(
            this, 0, stopIntent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        //---   Tạo hành động dừng  ---
        val stopAction = NotificationCompat.Action.Builder(
            R.drawable.ic_stop, "Dừng", stopPendingIntent
        ).build()

        // Tạo Notification với hành động dừng
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Music Foreground Service")
            .setContentText("Đang phát nhạc")
            .setSmallIcon(R.drawable.ic_stop)
            .addAction(stopAction) //-> Thêm nút dừng vào Notification
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
    }

    //===   Tạo Notification Channel   ===
    private fun createNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Music Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}
