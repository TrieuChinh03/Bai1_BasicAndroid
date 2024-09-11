package dnt.kotlin.bai1_basicandroid.customlistview

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dnt.kotlin.bai1_basicandroid.R

class ActivityListView : AppCompatActivity() {

    private var userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listView = findViewById<ListView>(R.id.listView)
        val userAdapter = UserAdapter(this, userList)
        listView.adapter = userAdapter

        val btAdd = findViewById<FloatingActionButton>(R.id.btAdd)
        btAdd.setOnClickListener {
            val dialog = Dialog()
            dialog.show(supportFragmentManager, "dialog")
            dialog.setOnUserAddListener(object : Dialog.UserListener {
                override fun onUserAdded(user: User) {
                    userList.add(user)
                    userAdapter.notifyDataSetChanged()
                }
            })
        }
    }
}