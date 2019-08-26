package com.example.testeeasynvest.util

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat

class Helpers {
    companion object {
        fun formatDate(dateParam: String): String {
            val parser = SimpleDateFormat("yyyy-MM-dd")
            val formatter = SimpleDateFormat("dd/MM/yyyy")
            return formatter.format(parser.parse(dateParam))
        }

        fun verifyAvailableNetwork(activity: AppCompatActivity): Boolean {
            val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }

        fun formatDateReverse(dateParam: String): String {
            val parser = SimpleDateFormat("dd/MM/yyyy")
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            return formatter.format(parser.parse(dateParam))
        }
    }
}