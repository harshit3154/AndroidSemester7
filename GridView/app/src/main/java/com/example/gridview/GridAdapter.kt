package com.example.gridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter(context: Context,
                  var items:MutableList<GridModel>):ArrayAdapter<GridModel>(context,0,items) {
    lateinit var view:View
    lateinit var text:TextView
    lateinit var img:ImageView
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        view=LayoutInflater.from(context).inflate(R.layout.grid_layout_view,parent,false)

        text=view.findViewById(R.id.tv)
        img=view.findViewById(R.id.iv)
        var mItems=items[position]
        img.setImageDrawable(context.resources.getDrawable(mItems.img))
        text.text=mItems.title

        return view
    }

}