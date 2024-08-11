package com.example.mainproject

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var mCtx:Context,
                var resources:Int,
    var items:MutableList<ModelDomo>):ArrayAdapter<ModelDomo>(mCtx,resources,items){
        override fun getView(position:Int,converView:View?,parent:ViewGroup):View{
            val layoutInflator:LayoutInflater=LayoutInflater.from(mCtx)
            val view:View=layoutInflator.inflate(resources,null)
            val imageView: ImageView =view.findViewById(R.id.image)
            val titleTextView: TextView =view.findViewById(R.id.textView1)
            val descriptionTextView:TextView=view.findViewById(R.id.textView2)
            val mItem=items[position]

            //imageView.setImageDrawable(mCtx.resources.getDrawable(mItem.img))
            imageView.setImageURI(Uri.parse(mItem.img.toString()))
            titleTextView.text=mItem.title
            descriptionTextView.text=mItem.subtitle
            val delete:Button=view.findViewById(R.id.del)
            delete.setOnClickListener(){
                items.removeAt(position)
                notifyDataSetChanged()
            }
            return view
        }
}