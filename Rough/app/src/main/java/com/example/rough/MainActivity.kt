package com.example.rough

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var listView:ListView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.listView)
        val list= arrayOf("Bihar","Delhi","Hyderbad","Mussorie","srinagar","Tokyo")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter
    }
}