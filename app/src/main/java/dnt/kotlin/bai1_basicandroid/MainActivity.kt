package dnt.kotlin.bai1_basicandroid

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import dnt.kotlin.bai1_basicandroid.activity_intent.Activity1
import dnt.kotlin.bai1_basicandroid.broadcast_receiver.NetworkChangeReceiver
import dnt.kotlin.bai1_basicandroid.customlistview.ActivityListView
import dnt.kotlin.bai1_basicandroid.fragment.Activity_Fragment_1
import dnt.kotlin.bai1_basicandroid.fragment.Activity_Fragment_2
import dnt.kotlin.bai1_basicandroid.service.ActivityService
import dnt.kotlin.bai1_basicandroid.service.MusicBackgroundService
import dnt.kotlin.bai1_basicandroid.service.MusicForegroundService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //===   1. Activity - Intent   ===
        val btActivityIntent: Button = findViewById(R.id.btActivityIntent)
        btActivityIntent.setOnClickListener {
            val intent = Intent(this, Activity1::class.java)
            startActivity(intent)
        }

        //===   2. Service   ===
        val btService: Button = findViewById(R.id.btBackgroundService)
        btService.setOnClickListener {
            val intent = Intent(this, MusicBackgroundService::class.java)
            startService(intent)
        }

        val btService1: Button = findViewById(R.id.btForegroundService)
        btService1.setOnClickListener {
            val intent = Intent(this, MusicForegroundService::class.java)
            startService(intent)
        }

        val btService2: Button = findViewById(R.id.btBoundService)
        btService2.setOnClickListener {
            val intent = Intent(this, ActivityService::class.java)
            startActivity(intent)
        }

        //===   3. Broadcast Receiver   ===
        val btBroadcastReceiver: Button = findViewById(R.id.btBroadcastReceiver)
        btBroadcastReceiver.setOnClickListener {
            val networkChangeReceiver = NetworkChangeReceiver()

            //---   Đăng ký BroadcastReceiver với IntentFilter cho sự thay đổi mạng     ---
            val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
            registerReceiver(networkChangeReceiver, intentFilter)
        }

        //===   4. Fragment   ===
        val btFragment1: Button = findViewById(R.id.btFragment1)
        btFragment1.setOnClickListener {
            val intent = Intent(this, Activity_Fragment_1::class.java)
            startActivity(intent)
        }

        val btFragment2: Button = findViewById(R.id.btFragment2)
        btFragment2.setOnClickListener {
            val intent = Intent(this, Activity_Fragment_2::class.java)
            startActivity(intent)
        }

        //===   5. Custom Listview   ===
        val btListView: Button = findViewById(R.id.btListView)
        btListView.setOnClickListener {
            val intent = Intent(this, ActivityListView::class.java)
            startActivity(intent)
        }


    }
}