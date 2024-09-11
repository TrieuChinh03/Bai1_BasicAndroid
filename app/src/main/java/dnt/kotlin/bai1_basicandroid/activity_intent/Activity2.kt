package dnt.kotlin.bai1_basicandroid.activity_intent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dnt.kotlin.bai1_basicandroid.R

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val data = intent.getStringExtra("key")
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = data

        val bundle = intent.extras
        val value = bundle?.getString("key")
        val textView1 = findViewById<TextView>(R.id.textView1)
        textView1.text = value
    }
}