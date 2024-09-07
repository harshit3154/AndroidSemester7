package com.example.servicemanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MusicPlayer : AppCompatActivity() {
    private lateinit var start:Button
    private lateinit var stop:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_music_player)
        start=findViewById(R.id.startt)
        stop=findViewById(R.id.stopp)
        start.setOnClickListener(){
            startService(Intent())
        }
        stop.setOnClickListener(){
            stopService(Intent())
        }
    }
}