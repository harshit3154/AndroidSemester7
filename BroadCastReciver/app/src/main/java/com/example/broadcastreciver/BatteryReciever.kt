package com.example.broadcastreciver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.TextView
import android.widget.Toast

class BatteryReciever(var tv:TextView,val context: Context):BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val perc=intent?.getIntExtra("level",0)
        if(perc!=0){
            tv.text="$perc%"
        }
        val batteryStatus=intent?.getIntExtra(BatteryManager.EXTRA_STATUS,0)
        val isCharging:Boolean=batteryStatus==BatteryManager.BATTERY_STATUS_CHARGING || batteryStatus==BatteryManager.BATTERY_STATUS_FULL
        if(isCharging)
            Toast.makeText(context,"Charger connected",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Charger disconnected",Toast.LENGTH_SHORT).show()


    }

}