package com.example.customviewdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(context:Context,
    var resources:Int,
    var list: MutableList<ModelCustom>
    ):ArrayAdapter<ModelCustom>(context,resources,list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var layoutInflater:LayoutInflater=LayoutInflater.from(context)
        var view:View=layoutInflater.inflate(resources,null)
        var imageView:ImageView=view.findViewById(R.id.image)
        var title:TextView=view.findViewById(R.id.title)
        var subtitle:TextView=view.findViewById(R.id.subtitle)
        val mItem=list[position]
        imageView.setImageDrawable(context.resources.getDrawable(mItem.img))
        title.text=mItem.title
        subtitle.text=mItem.subtitle
        return view
    }
}