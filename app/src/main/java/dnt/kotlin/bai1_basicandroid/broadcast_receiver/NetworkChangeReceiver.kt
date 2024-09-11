package dnt.kotlin.bai1_basicandroid.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent != null) {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo

            if (networkInfo != null && networkInfo.isConnected) {
                Toast.makeText(context, "Network is connected", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Network is disconnected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
