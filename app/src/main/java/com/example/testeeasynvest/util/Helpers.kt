package com.example.testeeasynvest.util

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.testeeasynvest.BaseApp
import java.text.SimpleDateFormat

class Helpers {
    companion object {
        fun formatDate(dateParam: String): String {
            val parser = SimpleDateFormat("yyyy-MM-dd")
            val formatter = SimpleDateFormat("dd/MM/yyyy")
            return formatter.format(parser.parse(dateParam))
        }

        fun verifyAvailableNetwork(activity: AppCompatActivity): Boolean {
            val connectivityManager =
                activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }

        fun formatDateReverse(dateParam: String): String {
            val parser = SimpleDateFormat("dd/MM/yyyy")
            val formatter = SimpleDateFormat("yyyy-MM-dd")
            return formatter.format(parser.parse(dateParam))
        }

        fun alertDialog(title: String, message: String) {

            // Initialize a new instance of
            val builder = AlertDialog.Builder(BaseApp.instance)

            // Set the alert dialog title
            builder.setTitle(title)

            // Display a message on alert dialog
            builder.setMessage(message)

            // Set a positive button and its click listener on alert dialog
            builder.setPositiveButton("YES") { dialog, which ->
                // Do something when user press the positive button
                dialog.dismiss()
            }

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface
            dialog.show()
        }
    }
}