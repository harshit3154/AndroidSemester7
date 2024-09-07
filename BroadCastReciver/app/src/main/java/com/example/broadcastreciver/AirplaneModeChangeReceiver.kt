package com.example.broadcastreciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView
import android.widget.Toast

class AirplaneModeChangeReceiver(var tv:TextView,context: Context?):BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled=intent?.getBooleanExtra("state", false)?:return
        if(isAirplaneModeEnabled){
            Toast.makeText(context,"is enabled",Toast.LENGTH_SHORT).show()
            tv.text="Airplane mode is enabled"
        }else{
            Toast.makeText(context,"is disabled",Toast.LENGTH_SHORT).show()
            tv.text="Airplane mode is diabled"
        }
    }
}