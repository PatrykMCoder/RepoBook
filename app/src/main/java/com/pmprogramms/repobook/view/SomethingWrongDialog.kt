package com.pmprogramms.repobook.view

import android.app.AlertDialog
import android.app.Application
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.pmprogramms.repobook.R
import kotlin.system.exitProcess

class SomethingWrongDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builderDialog = AlertDialog.Builder(context)
            .setTitle(R.string.something_wrong_title)
            .setMessage(R.string.something_wrong_message)
            .setNeutralButton("OK", DialogInterface.OnClickListener { dialog, which ->
                exitProcess(0)
            })
            .create()
        return builderDialog
    }
}