package com.cliffex.qaaf.Utility

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.example.androidnewproject.R


object AppUtility {
    private fun showMessage(context: Context, internetMessage: String) {
        Toast.makeText(context, internetMessage, Toast.LENGTH_SHORT).show()
    }

    //    private static void showActivity(Context context) {
    //       context.startActivity(new Intent(context, NoInternet.class));
    //
    //    }
    fun isNetworkAvailable(context: Context?, isToNotifyUser: Boolean): Boolean {
        if (context == null) return false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
        if (isToNotifyUser && !isConnected) {
            showMessage(context, "No Internet")
            // AppUtility.showActivity(context);
        }
        return isConnected
    }
}