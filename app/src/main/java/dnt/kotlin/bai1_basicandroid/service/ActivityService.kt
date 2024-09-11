package dnt.kotlin.bai1_basicandroid.service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dnt.kotlin.bai1_basicandroid.R

class ActivityService : AppCompatActivity() {

    private lateinit var edtNumber1: EditText
    private lateinit var edtNumber2: EditText
    private lateinit var tvResult: TextView
    private lateinit var btCalculate: Button

    private var calculationService: BoundService? = null
    private var isBound = false

    //===   Kết nối tới Service     ===
    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val binder = service as BoundService.LocalBinder
            calculationService = binder.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        edtNumber1 = findViewById(R.id.edtNumber1)
        edtNumber2 = findViewById(R.id.edtNumber2)
        tvResult = findViewById(R.id.tvResult)
        btCalculate = findViewById(R.id.btCalculate)

        //---   Kết nối với service     ---
        val intent = Intent(this, BoundService::class.java)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)

        // Xử lý khi nhấn nút tính toán
        btCalculate.setOnClickListener {
            if (isBound) {
                val num1 = edtNumber1.text.toString().toInt()
                val num2 = edtNumber2.text.toString().toInt()

                //---   Gọi hàm trong Service để tính toán  ---
                val result = calculationService?.sum(num1, num2)

                //---   Hiển thị kết quả    ---
                tvResult.text = result.toString()
            }
        }
    }
}