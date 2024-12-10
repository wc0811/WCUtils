package com.yp.wcutils.ext

import android.view.View

abstract class NoDoubleClickListener : View.OnClickListener {

    private var lastClickTime: Long = 0

    override fun onClick(v: View) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime
            onNoDoubleClick(v)
        }
    }

    protected abstract fun onNoDoubleClick(v: View)

    companion object {
        const val MIN_CLICK_DELAY_TIME = 500L
    }
}

// 为 View 添加方法，以后使用这个方法来替换 setOnClickListener 就可以了
fun View.noDoubleClickListener(click: (view: View) -> Unit) {
    setOnClickListener(object : NoDoubleClickListener() {
        override fun onNoDoubleClick(v: View) {
            click(v)
        }
    })
}