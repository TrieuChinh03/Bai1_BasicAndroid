package dnt.kotlin.bai1_basicandroid.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import dnt.kotlin.bai1_basicandroid.R

class Activity_Fragment_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment2)

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentContainer1, Fragment1())
        transaction.add(R.id.fragmentContainer2, Fragment2())
        transaction.commit()
    }
}