package com.example.customgridviewdemo2

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
        gridView=findViewById(R.id.gv)
        var list= mutableListOf<CustomGridViewModel>()
        var adapter=CustomGridViewAdapter(this,list)
        list.add(CustomGridViewModel("Whatsapp",R.drawable.ic_launcher_background))
        list.add(CustomGridViewModel("Whatsapp",R.drawable.ic_launcher_background))
        gridView.adapter=adapter

    }
}