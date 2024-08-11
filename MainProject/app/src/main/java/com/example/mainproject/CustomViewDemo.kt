package com.example.mainproject

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomViewDemo : AppCompatActivity() {
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn:Button

    private lateinit var imageView:ImageView
    private var selectedImageUri:Uri?=null
    private val PICK_IMAGE=1
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_view_demo)
        var listView=findViewById<ListView>(R.id.custom_list_view)
        var list= mutableListOf<ModelDomo>()

        edt1=findViewById(R.id.edt1)
        edt2=findViewById(R.id.edt2)
        btn=findViewById(R.id.add)
        var ad=MyAdapter(this,R.layout.custom_look_file,list)
        imageView=findViewById(R.id.imageview)
        imageView.setOnClickListener(){
            val intent=Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent,PICK_IMAGE)
        }
        selectedImageUri?.let{
            imageView.setImageURI(it)
            list.add(ModelDomo(edt1.text.toString(),edt2.text.toString(),it))
            Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show()
            ad.notifyDataSetChanged()
            listView.adapter=ad
        }
        btn.setOnClickListener(){
            //list.add(ModelDomo(edt1.text.toString(),edt2.text.toString(),R.drawable.facebook))
            /*  list.add(ModelDomo("Whatsapp","Whatsapp description",R.drawable.whatsapp))
                list.add(ModelDomo("Instagram","Instagram descripiton",R.drawable.instagram))
                list.add(ModelDomo("Titok","Tiktok description",R.drawable.titok))
               */

            listView.adapter=ad
        }
        /*listView.setOnItemClickListener { parent, view, position, id ->
            list.removeAt(position)
            ad.notifyDataSetChanged()
        }*/

        /*listView.setOnItemLongClickListener { parent, view, position, id ->
            var b=AlertDialog.Builder(this)
            b.setTitle("Are you sure ?")
            b.setCancelable(true)
            b.setPositiveButton("Yes"){
                a,b->
                list.removeAt(position)
                ad.notifyDataSetChanged()
            }

            b.setNegativeButton("No"){
                a,b->
                a.dismiss()
            }
            b.show()

            true
        }*/
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode==PICK_IMAGE && resultCode== Activity.RESULT_OK){
            selectedImageUri=data?.data
            selectedImageUri.let{
                val bitmap:Bitmap=MediaStore.Images.Media.getBitmap(this.contentResolver,it)
                imageView.setImageBitmap(bitmap)
            }
        }
    }
}