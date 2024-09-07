package com.example.rough

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomListView : AppCompatActivity() {
    lateinit var listView: ListView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view)
        listView=findViewById(R.id.listViewC)
        var list= mutableListOf<CustomModel>()
        list.add(CustomModel("Ic launcher","Green background",R.drawable.ic_launcher_background))
        var adapter=CustomAdapter(this,R.layout.activity_custom_list_view,list)
        listView.adapter=adapter
    }
}