package com.yp.wcutils.ext

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

inline fun <reified T> Activity.navigateTo(isFinish: Boolean = false) {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
    if (isFinish) {
        finish()
    }
}

fun View.hideKeyboard(context: Context) {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}


internal fun Calendar.formatDate(): String {
    return SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(this.time)
}
