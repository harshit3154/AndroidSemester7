package com.example.customgridviewdemo2

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var gridView:GridView
    lateinit var imageView:ImageView
    lateinit var button:Button
    lateinit var edt1:EditText

    var selectedImageUri:Uri?=null
    val PICK_IMAGE=1
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        gridView=findViewById(R.id.gv)
        imageView=findViewById(R.id.add)
        imageView.setOnClickListener(){
            val intent=Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent,PICK_IMAGE)
        }

        var list= mutableListOf<CustomGridViewModel>()
        var adapter=CustomGridViewAdapter(this,list)

        button=findViewById(R.id.btn)

        button.setOnClickListener(){
            edt1=findViewById(R.id.edt1)

            selectedImageUri?.let{
                list.add(CustomGridViewModel(edt1.text.toString(),it))
                adapter.notifyDataSetChanged()
                Toast.makeText(this,"Image has been selected.",Toast.LENGTH_SHORT).show()
            }
        }
//        list.add(CustomGridViewModel("Whatsapp",R.drawable.whatsapp))
//        list.add(CustomGridViewModel("Whatsapp",R.drawable.facebook))
//        list.add(CustomGridViewModel("Whatsapp",R.drawable.titok))
//        list.add(CustomGridViewModel("Whatsapp",R.drawable.instagram))
        gridView.adapter=adapter

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==PICK_IMAGE && resultCode== RESULT_OK){
            selectedImageUri=data?.data
            selectedImageUri?.let {
                val bitmap:Bitmap=MediaStore.Images.Media.getBitmap(this.contentResolver,it)
                imageView.setImageBitmap(bitmap)

            }
        }
    }
}