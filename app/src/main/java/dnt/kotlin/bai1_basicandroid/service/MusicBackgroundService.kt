package dnt.kotlin.bai1_basicandroid.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import dnt.kotlin.bai1_basicandroid.R

class MusicBackgroundService : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()

        //---   Khởi tạo MediaPlayer   ---
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.isLooping = true
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //---   Bắt đầu phát nhạc khi Service được khởi động    ---
        mediaPlayer.start()
        return START_STICKY //->Service tiếp tục chạy ngay cả khi bị hệ thống dừng
    }

    //===   Dừng nhạc và giải phóng tài nguyên khi Service bị hủy ===
    override fun onDestroy() {
        Log.d("BackgroundService", "Dừng service")
        mediaPlayer.stop()
        mediaPlayer.release()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
