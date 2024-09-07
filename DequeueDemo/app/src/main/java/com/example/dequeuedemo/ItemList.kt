package com.example.dequeuedemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ItemList : AppCompatActivity() {
    var list= mutableListOf<CustomModel>()
    lateinit var listView: ListView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item_list)
        listView=findViewById(R.id.listView)
        addData()
        var adapter=MyAdapter(this,R.layout.cusom_list_view,list)
        listView.adapter=adapter
    }

    private fun addData() {
        list.add(CustomModel(R.drawable.ic_launcher_background,"ic_launcer","It's a green color background image","0.0"))
    }
}