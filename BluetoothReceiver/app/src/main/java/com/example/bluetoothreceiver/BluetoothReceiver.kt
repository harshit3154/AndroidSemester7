package com.example.bluetoothreceiver

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BluetoothReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val state=intent?.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)
        val message= when(state){
            BluetoothAdapter.STATE_OFF->"Bluetootl is off"
            BluetoothAdapter.STATE_ON->"Bluetooth is on"
            BluetoothAdapter.STATE_TURNING_ON->"Bluetooth is turning on"
            BluetoothAdapter.STATE_TURNING_OFF->"Bluetooth is turnign off"
            else->"Bluetooth state unknown"
        }
        if(context is MainActivity){
            context.updateBluetoothState(message)
        }
    }
}