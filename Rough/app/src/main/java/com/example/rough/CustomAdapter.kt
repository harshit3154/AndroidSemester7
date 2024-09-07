package com.example.rough

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class CustomAdapter(context:Context,var resources: Int,var list: MutableList<CustomModel>)
    :ArrayAdapter<CustomModel>(context,resources,list) {
    lateinit var title:TextView
    lateinit var subtitle:TextView
    lateinit var imageView: ImageView
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view=LayoutInflater.from(context).inflate(resources,null)
        title=view.findViewById(R.id.titlec)
        subtitle=view.findViewById(R.id.subtitle)
        imageView=view.findViewById(R.id.imageView)
        val mitem=list[position]
        title.text=mitem.title
        subtitle.text=mitem.subtitle
        imageView.setImageDrawable(context.getDrawable(mitem.img))
        return view
    }
}