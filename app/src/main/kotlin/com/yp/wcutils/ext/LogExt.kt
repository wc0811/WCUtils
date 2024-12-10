package com.yp.wcutils.ext

import android.util.Log

const val TAG = "YP__"

fun log(msg: String) {
    Log.v(TAG, msg)
}

fun send(msg: String) {
    // 创建邮箱
//    val mail = Mail().apply {
//        mailServerHost = "smtp.qq.com"
//        mailServerPort = "587"
//        fromAddress = "xxxxxxxx@foxmail.com"
//        password = "xxxxxxxx"
//        toAddress = arrayListOf("xxxxxxxx@qq.com")
//        subject = "MailSender"
//        content = "MailSender Android快速实现发送消息"
//        attachFiles = arrayListOf(file)
//    }

    // 发送邮箱
//    MailSender.getInstance().sendMail(mail)
}