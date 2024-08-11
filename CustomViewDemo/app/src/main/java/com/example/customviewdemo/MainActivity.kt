package com.example.customviewdemo

import android.os.Bundle
import android.widget.Adapter
import android.widget.ImageView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.listView)
        var list= mutableListOf<ModelCustom>()
        var adapter=CustomAdapter(this,R.layout.custom_view_look,list)
        list.add(ModelCustom("Whatsapp","Whatsapp description",R.drawable.whatsapp))
        list.add(ModelCustom("Instagram","Instagram descripiton",R.drawable.instagram))
        list.add(ModelCustom("Titok","Tiktok description",R.drawable.titok))
        listView.adapter=adapter
    }
}