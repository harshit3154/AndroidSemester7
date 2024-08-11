package com.example.mainproject

import android.annotation.SuppressLint
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var lv:ListView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var ar= arrayOf("India","Dubai","USA","NEW YORK","London","Singapore","Portugal","Africa","Monaco")
        lv=findViewById(R.id.listView)
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,ar)
        lv.adapter=adapter
        lv.setOnItemClickListener(){ adapterView, view, i,l->
            var value:String=ar[i] as String
            Toast.makeText(applicationContext,"$value",Toast.LENGTH_SHORT).show()
        }
    }
}


