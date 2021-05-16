package com.pmprogramms.repobook.helper

import android.content.Context
import android.net.ConnectivityManager

class InternetConnectionHelper {
    fun checkInternetConnection(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected // update it to callbacks
    }
}