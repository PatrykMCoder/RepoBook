package com.pmprogramms.repobook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmprogramms.repobook.helper.InternetConnectionHelper
import com.pmprogramms.repobook.view.dialog.SomethingWrongDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val network = InternetConnectionHelper()


        if (!network.checkInternetConnection(applicationContext)) {
            val somethingWrongDialog = SomethingWrongDialog()
            somethingWrongDialog.show(supportFragmentManager, "SomethingWrong")
        }
    }
}