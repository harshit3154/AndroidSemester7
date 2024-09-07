package com.example.couroutinedirectdownload

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle

import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private val imageURL="https://img.freepik.com/free-vector/cute-happy-smiling-child-isolated-white_1308-32243.jpg"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        imageView=findViewById(R.id.images)
        // Launch a coroutine in the life cycle
        lifecycleScope.launch(Dispatchers.IO){
            val imageData= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                fetchImage(imageURL)
            } else {
                TODO("VERSION.SDK_INT < UPSIDE_DOWN_CAKE")
            }
            if(imageData!=null){
                //Decode the byte array into a bitmap
                val bitmap=BitmapFactory.decodeByteArray(imageData,0,imageData.size)
                //switch to the main thread to update UI
                withContext(Dispatchers.Main){
                    imageView.setImageBitmap(bitmap)
                }
            }
        }
    }
    // suspending the funtion to fetch image data.
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    private suspend fun fetchImage(url:String):ByteArray?{
        return withContext(Dispatchers.IO){
            val client= OkHttpClient()
            val request= Request
                .Builder()
                .url(url)
                .build()
            val response=client.newCall(request).execute()
            if(response.isSuccessful){
                response.body?.bytes()
            }else{
                null
            }
        }
    }
}