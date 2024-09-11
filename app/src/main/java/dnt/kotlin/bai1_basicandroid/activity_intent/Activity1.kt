package dnt.kotlin.bai1_basicandroid.activity_intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dnt.kotlin.bai1_basicandroid.R

class Activity1 : AppCompatActivity() {

    //===   Truyền dữ liệu sử dụng Intent   ===
    private fun passingDataWithIntent() {
        val intent = Intent(this, Activity2::class.java)
        intent.putExtra("key", "Sử dụng Intent")
        startActivity(intent)
    }

    //===   Truyền dữ liệu sử dụng Bundle   ===
    private fun passingDataWithBundle() {
        val intent = Intent(this, Activity2::class.java)
        val bundle = Bundle()
        bundle.putString("key", "Sử dụng Bundle")
        intent.putExtras(bundle)
        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("onCreate", "Khởi tạo activity")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        val btIntent: Button = findViewById(R.id.btIntent)
        val btBundle: Button = findViewById(R.id.btBundle)

        btIntent.setOnClickListener {
            passingDataWithIntent()
        }

        btBundle.setOnClickListener {
            passingDataWithBundle()
        }
    }

    override fun onStart() {
        Log.d("onStart", "Bắt đầu hoạt động - chưa thể tương tác")
        super.onStart()
    }

    override fun onResume() {
        Log.d("onResume", "Hoạt động - có thể tương tác")
        super.onResume()
    }

    override fun onPause() {
        Log.d("onPause", "Hủy hoạt động")
        super.onPause()
    }

    override fun onStop() {
        Log.d("onStop", "Dừng hoạt động")
        super.onStop()
    }

    override fun onRestart() {
        Log.d("onRestart", "Khôi phục hoạt động sau khi dừng")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d("onDestroy", "Hủy activity")
        super.onDestroy()
    }

}