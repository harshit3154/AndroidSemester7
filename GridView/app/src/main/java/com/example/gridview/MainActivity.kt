package com.example.gridview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var gridView:GridView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        gridView = findViewById(R.id.gd)
        val list = mutableListOf<GridModel>()
        list.add(GridModel("Facebook",R.drawable.facebook))
        list.add(GridModel("Whatsapp", R.drawable.whatsapp))
        list.add(GridModel("Instagram",R.drawable.instagram))
        list.add(GridModel("Tiktok",R.drawable.titok))
        list.add(GridModel("Google",R.drawable.google))
        gridView.adapter=GridAdapter(this,list)
    }
}