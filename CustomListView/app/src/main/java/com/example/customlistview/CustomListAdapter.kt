package com.example.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomListAdapter(context:Context,
                        var resource:Int,
    var list:MutableList<CustomListModel>):ArrayAdapter<CustomListModel>(context,resource,list){
        lateinit var title:TextView
        lateinit var subtitle:TextView
        lateinit var image:ImageView
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view:View=LayoutInflater.from(context).inflate(resource, null)
        title=view.findViewById(R.id.title)
        subtitle=view.findViewById(R.id.subtitle)
        image=view.findViewById(R.id.image)
        val mItem=list[position]
        title.text=mItem.title
        subtitle.text=mItem.subtitle
        image.setImageDrawable(context.resources.getDrawable(mItem.image))
        return view
    }
}