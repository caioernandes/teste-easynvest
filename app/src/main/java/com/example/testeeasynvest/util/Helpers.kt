package com.example.testeeasynvest.util

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.testeeasynvest.BaseApp
import java.text.SimpleDateFormat
import android.text.TextUtils
import android.text.Editable
import android.view.View
import android.widget.EditText



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

        fun alertDialog(title: String, message: String, context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setMessage(message)
            builder.setPositiveButton("OK") { dialog, which ->
                dialog.dismiss()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        fun validateNotNull(pView: View, pMessage: String, showError: Boolean): Boolean {
            if (pView is EditText) {
                val edText = pView
                val text = edText.text
                if (text != null) {
                    val strText = text.toString()
                    if (!TextUtils.isEmpty(strText)) {
                        return true
                    }
                }

                if (showError) {
                    edText.error = pMessage
                    edText.isFocusable = true
                    edText.requestFocus()
                }

                return false
            }
            return false
        }
    }
}