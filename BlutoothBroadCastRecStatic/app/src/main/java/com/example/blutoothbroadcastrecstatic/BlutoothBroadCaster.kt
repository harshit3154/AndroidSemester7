package com.example.blutoothbroadcastrecstatic

import android.app.Service
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder

class BlutoothBroadCaster:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val action=intent?.action
        val statusMessage=when(action){
            BluetoothDevice.ACTION_ACL_CONNECTED->"Bluetooth device connected"
            BluetoothDevice.ACTION_ACL_DISCONNECTED->"Bluetooth device disconnected"
            else->"Unknow Bluetooth action"
        }

        val statusIntent=Intent("com.example.blutoothbroadcastrecstatic").apply {
            putExtra("status",statusMessage)
        }
        context?.sendBroadcast(statusIntent)
    }
}