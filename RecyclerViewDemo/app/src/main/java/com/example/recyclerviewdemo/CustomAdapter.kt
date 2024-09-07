package com.example.recyclerviewdemo

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class CustomAdapter(var context:Context,
                    var l:MutableList<CustomModel>)
    :RecyclerView.Adapter<CustomAdapter.MyHolder>() {
    class MyHolder(var v:View):RecyclerView.ViewHolder(v){
        var name=v.findViewById<TextView>(R.id.txt)
        var image=v.findViewById<ImageView>(R.id.img)
        var delete=v.findViewById<Button>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var v:View=LayoutInflater.from(context).inflate(R.layout.custom_design_view,parent,false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int {
        return l.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.name.text=l[position].title
        holder.image.setImageResource(l[position].image)
    }

}