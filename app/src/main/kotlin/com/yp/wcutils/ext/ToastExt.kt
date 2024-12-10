package com.yp.wcutils.ext

import android.app.Activity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Activity.showToast(
    msg: String? = null
) {
    if (!msg.isNullOrBlank()) {
        val builder = MaterialAlertDialogBuilder(this)
        builder.setMessage(msg)
        builder.setPositiveButton("确定") { _, _ ->
        }
        builder.show()
    }
}
