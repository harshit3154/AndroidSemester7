package com.example.bluetoothreceiver

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.status)

    }

    override fun onResume() {
        super.onResume()
        // Register the receiver
        val filter=IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        registerReceiver(bluetoothReceiver,filter)
    }

    override fun onPause() {
        super.onPause()
        //unregisterReceiver
        unregisterReceiver(bluetoothReceiver)
    }
    fun updateBluetoothState(message:String){
        textView.text=message
    }
}