package dnt.kotlin.bai1_basicandroid.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class BoundService : Service() {
    //===   Khởi tạo Binder kết nối với Activity     ===
    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService(): BoundService = this@BoundService
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    //===   Hàm cộng hai số     ===
    fun sum(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}