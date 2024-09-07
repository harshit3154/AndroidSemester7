package com.example.listview

import android.os.Build.VERSION_CODES.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import android.widget.Toast.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list=arrayOf("INDIA","USA","LONDON","AMERICA","ISRAIL","PHILISTIN","CHINA","TOKYO")
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        var listView:ListView=findViewById(R.id.listView)
        listView.adapter=adapter
        /*listView.setOnItemClickListener() { parent, view, position, id ->

            var str=list[position].toString()
            var b=AlertDialog.Builder(this)
            b.setTitle("Do you want to process furhter? ")
            b.setIcon(android.R.drawable.sym_def_app_icon)
            b.setCancelable(true)
            b.setPositiveButton("YES"){
                a,b->
                Toast.makeText(this,"You have clicked $str", Toast.LENGTH_LONG).show()
            }
            b.setNegativeButton("NO"){
                a,n->
            }
            b.show()
            true

        }*/

        listView.setOnItemLongClickListener { parent, view, position, id ->
            var b=AlertDialog.Builder(this)
            b.setTitle("Do you want to delete this?")
            b.setPositiveButton("YES"){
                a,b->
                    listView.removeViewAt(position)
                    adapter.notifyDataSetChanged()
            }
            b.setNegativeButton("NO"){
                a,b->
                    Toast.makeText(this,"Ok cancelling the operation.",Toast.LENGTH_SHORT).show()
                    a.cancel()
            }
            b.show()
            true
        }
    }
}