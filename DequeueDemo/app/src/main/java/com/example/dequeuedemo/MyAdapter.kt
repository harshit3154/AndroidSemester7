package com.example.dequeuedemo

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(context: Context,var resources: Int,var list:MutableList<CustomModel>)
    :ArrayAdapter<CustomModel>(context,resources,list){
        lateinit var name:TextView
        lateinit var description:TextView
        lateinit var cost:TextView
        lateinit var img:ImageView
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view=LayoutInflater.from(context).inflate(resources,null)
        name=view.findViewById(R.id.name)
        description=view.findViewWithTag(R.id.description)
        cost=view.findViewById(R.id.cost)
        img=view.findViewById(R.id.image)
        var mItem=list[position]
        name.text=mItem.name
        description.text=mItem.description
        cost.text=mItem.price
        img.setImageDrawable(context.getDrawable(mItem.image))
        return view
    }
}
