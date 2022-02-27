package kozlov.artyom.ctf.utils

import android.content.Context
import android.net.ConnectivityManager


object InternetConnection {

    private fun checkConnection(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

    private fun internetIsConnected(): Boolean {
        return try {
            val command = "ping -c 1 google.com"
            Runtime.getRuntime().exec(command).waitFor() == 0
        } catch (e: Exception) {
            false
        }
    }

    fun checkInternet(context: Context): Boolean{
        return checkConnection(context) || internetIsConnected()
    }

}