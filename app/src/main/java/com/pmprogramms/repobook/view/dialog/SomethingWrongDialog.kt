package com.pmprogramms.repobook.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.pmprogramms.repobook.R
import kotlin.system.exitProcess

class SomethingWrongDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(context)
            .setTitle(R.string.something_wrong_title)
            .setMessage(R.string.something_wrong_message)
            .setNeutralButton("OK") { _, _ ->
                exitProcess(0)
            }
            .setIcon(R.drawable.ic_baseline_warning_24)
            .create()
    }
}