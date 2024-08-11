package com.example.customdemo2

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var imageView1:ImageView
    lateinit var imageView2:ImageView
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    private var selectedImageUri:Uri?=null
    private val PICK_IMAGE=1
    lateinit var adapter:CustomListAdapter
    var list= mutableListOf<CustomListModel>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listView=findViewById(R.id.listView)
        adapter=CustomListAdapter(this,R.layout.custom_list_look,list)
        /*
        list.add(CustomListModel("Whatsapp","Whatsapp description",R.drawable.whatsapp))
        list.add(CustomListModel("Whatsapp","Whatsapp description",R.drawable.whatsapp))
        list.add(CustomListModel("Whatsapp","Whatsapp description",R.drawable.whatsapp))
        */

        imageView2=findViewById(R.id.image2)
        imageView2.setOnClickListener(){
            startActivityForResult(Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI),PICK_IMAGE)
        }


        listView.setOnItemClickListener { parent, view, position, id ->
            val a=AlertDialog.Builder(this)
            a.setTitle("Do you want to delete this ?")
            a.setPositiveButton("YES"){
                a,b->
                list.removeAt(position)
                adapter.notifyDataSetChanged()
            }
            a.setNegativeButton("NO"){
                a,b->
                list.removeAt(position)
                adapter.notifyDataSetChanged()
            }
            a.show()
            true
        }
        /*
        listView.setOnItemLongClickListener { parent, view, position, id ->
            val a=AlertDialog.Builder(this)
            a.setTitle("Do you want to delete?")
            a.setPositiveButton("YES"){
                a,b->
                list.removeAt(position)
                adapter.notifyDataSetChanged()
            }
            a.setNegativeButton("NO"){
                a,b->
                Toast.makeText(this,"Neglecting the change",Toast.LENGTH_SHORT).show()
            }
            a.show()
            true
        }
        */
        listView.adapter=adapter
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==PICK_IMAGE && resultCode== Activity.RESULT_OK){
            selectedImageUri=data?.data
            selectedImageUri?.let{
                val bitmap:Bitmap=MediaStore.Images.Media.getBitmap(this.contentResolver,it)
                imageView2.setImageBitmap(bitmap)
                edt1=findViewById(R.id.edt1)
                edt2=findViewById(R.id.edt2)
                list.add(CustomListModel(edt1.text.toString(),edt2.text.toString(),it))
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
                listView.adapter=adapter

            }
        }else{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }
}