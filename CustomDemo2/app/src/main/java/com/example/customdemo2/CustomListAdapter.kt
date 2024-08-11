package com.example.customdemo2

import android.content.Context
import android.content.res.Resources
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class CustomListAdapter(var mCtx:Context,var resources:Int,
                                     var items:MutableList<CustomListModel>)
    :ArrayAdapter<CustomListModel>(mCtx,resources,items)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater:LayoutInflater=LayoutInflater.from(mCtx)
        val view:View=layoutInflater.inflate(resources,null)
        val imageView:ImageView=view.findViewById(R.id.img)
        val titleTextView:TextView=view.findViewById(R.id.title)
        val descriptionTextView:TextView=view.findViewById(R.id.subtitle)
        val mItem=items[position]
        imageView.setImageURI(Uri.parse(mItem.img.toString()))
        titleTextView.text=mItem.title
        descriptionTextView.text=mItem.subtitle
//        val delete:Button=view.findViewById(R.id.delete)
//        delete.setOnClickListener(){
//            items.removeAt(position)
//            notifyDataSetChanged()
//        }
        return view
    }
}

