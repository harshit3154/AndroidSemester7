package com.example.coroutinedemo

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        imageView=findViewById(R.id.image)
        val imageUrl = "https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg"
        downloadAndShowImage(imageUrl)
    }

    private fun downloadAndShowImage(imageUrl: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response=RetrofitClient.apiService.downloadImage(imageUrl)
                if(response.isSuccessful){
                    val responseBody: ResponseBody =response.body()!!
                    val inputStream:InputStream=responseBody.byteStream()
                    val bitmap:Bitmap=BitmapFactory.decodeStream(inputStream)
                    withContext(Dispatchers.Main){
                        imageView.setImageBitmap(bitmap)
                    }
                }else{
                   println("Failed to download image ${response.message()}")
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}