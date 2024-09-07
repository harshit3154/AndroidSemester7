package com.example.servicemanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundService:Service() {
    private val CHANNEL_ID="ForegroundService kotlin"
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input=intent?.getStringExtra("input")
        createNotificationChannel()
        val notificationIntent=Intent(this,MainActivity::class.java)
        val pendingIntent=PendingIntent.getActivity(this,0,notificationIntent,FLAG_IMMUTABLE)
        val notification=NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Foreground Service Kotlin Example")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()
        startForeground(1,notification)
        return START_STICKY
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val serviceChannel=NotificationChannel(CHANNEL_ID,"Foreground Service Channel",NotificationManager.IMPORTANCE_DEFAULT)
            val manager=getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(serviceChannel)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}
