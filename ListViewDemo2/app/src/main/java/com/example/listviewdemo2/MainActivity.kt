package com.example.listviewdemo2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var listView:ListView
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        listView=findViewById(R.id.listView)
        var list= arrayOf("India","China")
        var adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter
//        listView.setOnItemClickListener(){
//            parent,viewgroup,position,id->
//            var b=AlertDialog.Builder(this)
//            b.setTitle(" Do you want to continue ? ")
//            b.setIcon(android.R.drawable.sym_def_app_icon)
//            b.setCancelable(true)
//            b.setPositiveButton("YES"){
//                a,b->
//                Toast.makeText(this,list[position].toString(),Toast.LENGTH_SHORT).show()
//            }
//            b.setNegativeButton("NO"){
//                a,b->
//                Toast.makeText(this,"Cancelling the action!!!",Toast.LENGTH_SHORT).show()
//            }
//            b.show()
//            true
//        }

        listView.setOnItemLongClickListener(){
            parent,viewGroup,position,id->
            var b=AlertDialog.Builder(this)
            b.setTitle("Do you to continue ? ")
            b.setIcon(android.R.drawable.sym_def_app_icon)
            b.setCancelable(true)
            b.setPositiveButton("Yes"){
                a,b->
                    Toast.makeText(this,list[position].toString(),Toast.LENGTH_SHORT).show()
            }
            b.setNegativeButton("no"){
                a,b->
                    Toast.makeText(this,"Cancelling the action performed",Toast.LENGTH_SHORT).show()
            }
            b.show()
            true
        }
    }
}