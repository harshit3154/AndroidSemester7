package com.example.recyclerviewdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var rv:RecyclerView
    lateinit var ad:CustomAdapter
    lateinit var list:ArrayList<CustomModel>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        rv=findViewById(R.id.rv)
        rv.setHasFixedSize(true)
        addData()
        val gm=GridLayoutManager(this,2)
        gm.orientation=RecyclerView.VERTICAL
        rv.layoutManager=gm
        ad= CustomAdapter(this,list)
        rv.adapter=ad
        ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val deletedCourse: CustomModel =
                        list.get(viewHolder.adapterPosition)
                    val position = viewHolder.adapterPosition
                    list.removeAt(viewHolder.adapterPosition)
                    ad!!.notifyItemRemoved(viewHolder.adapterPosition)
                   /* Snackbar.make(rv, "Deleted " + deletedCourse.t, Snackbar.LENGTH_LONG)
                        .setAction("Undo",
                            .OnClickListener{
                                list.add(position, deletedCourse)
                                rv!!.notifyItemInserted(position)
                            }).show()*/
                }
            }).attachToRecyclerView(rv)
    }
    fun addData(){
        list=ArrayList<CustomModel>()
        list.add(CustomModel("Whatsapp",R.drawable.whatsapp))
        list.add(CustomModel("Facebook",R.drawable.facebook))
        list.add(CustomModel("Instagram",R.drawable.instagram))
        list.add(CustomModel("Tiktok",R.drawable.titok))
        list.add(CustomModel("Google",R.drawable.google))
        list.add(CustomModel("Whatsapp",R.drawable.whatsapp))
        list.add(CustomModel("Facebook",R.drawable.facebook))
        list.add(CustomModel("Instagram",R.drawable.instagram))
        list.add(CustomModel("Tiktok",R.drawable.titok))
        list.add(CustomModel("Google",R.drawable.google))
    }
    fun toast(str:String){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
    }
}