package com.example.customgridviewdemo2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomGridViewAdapter(context: Context,
                            var item:MutableList<CustomGridViewModel>)
    :ArrayAdapter<CustomGridViewModel>(context,0,item) {
        lateinit var view:View
        lateinit var text:TextView
        lateinit var img:ImageView

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            view=LayoutInflater.from(context).inflate(R.layout.custom_grid_design,parent,false)
            text=view.findViewById(R.id.tv)
            img=view.findViewById(R.id.image)
            var mItem=item[position]
            img.setImageDrawable(context.resources.getDrawable(mItem.img))
            return view
        }
}