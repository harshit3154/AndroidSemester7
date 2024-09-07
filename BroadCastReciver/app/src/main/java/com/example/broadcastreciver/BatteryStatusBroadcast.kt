package com.example.broadcastreciver

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BatteryStatusBroadcast : AppCompatActivity() {
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    lateinit var br:BatteryReciever
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_battery_status_broadcast)
        txt1=findViewById(R.id.txt1)
        txt2=findViewById(R.id.txt2)
        br= BatteryReciever(txt1,this)
        registerReceiver(br,IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(br)
    }
}