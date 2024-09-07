package com.example.customlistview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var listView:ListView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.listView)
        var list= mutableListOf<CustomListModel>()
        var adapter=CustomListAdapter(this,R.layout.custom_listview_design,list)
        list.add(CustomListModel(R.drawable.ic_launcher_background,"this","shit"))
        listView.adapter=adapter
    }
}