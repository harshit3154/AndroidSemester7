package com.example.videoapp

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private val videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        videoView = findViewById(R.id.videor)
        downloadAndPlayVideo(videoUrl)
    }

    private fun downloadAndPlayVideo(url: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val file = withContext(Dispatchers.IO) {
                    downloadVideo(url)
                }
                playVideo(file)
            } catch (e: Exception) {
                Log.e("MainActivity", "Failed to download or play video", e)
            }
        }
    }
    private fun downloadVideo(url: String): File {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        connection.connect()
        val inputStream: InputStream = connection.inputStream
        val file = File(cacheDir, "downloaded_video.mp4")
        FileOutputStream(file).use { outputStream ->
            inputStream.copyTo(outputStream)
        }
        inputStream.close()
        return file
    }
    private fun playVideo(file: File) {
        val videoUri: Uri = Uri.fromFile(file)
        videoView.setVideoURI(videoUri)
        videoView.start()
    }
}