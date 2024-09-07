package com.example.servicemanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btnstart:Button
    lateinit var btnstop:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Code for foregroud service
        btnstart=findViewById(R.id.start)
        btnstop=findViewById(R.id.stop)
        btnstart.setOnClickListener(){
            val startIntent=Intent(this,ForegroundService::class.java)
            startIntent.putExtra("inputExtra","Foreground service is running")
            ContextCompat.startForegroundService(this,startIntent)
        }
        btnstop.setOnClickListener(){
            val stopIntent=Intent(this,ForegroundService::class.java)

        }
    }
}