package com.ubayadev.studentapp.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.ubayadev.studentapp.R

fun createNotifChannel(context: Context, priority:Int, showBadge:Boolean, description:String) {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = context.getString(R.string.app_name)
        val channelId = "${context.packageName}-$name"
        val channel = NotificationChannel(channelId, name, priority)
        channel.description = description
        channel.setShowBadge(showBadge)

        val manager = context.getSystemService(NotificationManager::class.java)
        manager.createNotificationChannel(channel)
    }
}