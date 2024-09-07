package com.example.pdfapp

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
import android.graphics.pdf.PdfRenderer.Page.*
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
            private lateinit var imageView: ImageView
            private lateinit var textView: TextView
            private val pdfUrl = "https://www.iitk.ac.in/esc101/2009Jan/lecturenotes/timecomplexity/TimeComplexity_using_Big_O.pdf"

            @SuppressLint("MissingInflatedId")
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
                imageView = findViewById(R.id.imageView)
                textView = findViewById(R.id.textView)
                lifecycleScope.launch(Dispatchers.IO) {
                    withContext(Dispatchers.Main) {
                        textView.text = "Downloading PDF..."
                    }
                    val pdfFile = downloadPdf(pdfUrl)
                    if (pdfFile != null) {
                        withContext(Dispatchers.Main) {
                            textView.text = "PDF downloaded! Rendering the first page..."
                        }
                        val pdfBitmap = renderPdf(pdfFile)
                        pdfBitmap?.let{
                            withContext(Dispatchers.Main){
                                imageView.setImageBitmap(it)
                                textView.text="Failed to downlaod pdf please try again"
                            }
                        }
                    }
                }
            }

    private suspend fun renderPdf(pdfFile: File): Bitmap? {
        return withContext(Dispatchers.IO){
            val fileDescriptor=ParcelFileDescriptor.open(pdfFile,
                ParcelFileDescriptor.MODE_READ_WRITE)
            val pdfRenderer=PdfRenderer(fileDescriptor)
            val page=pdfRenderer.openPage(0)
            val width=page.width
            val height=page.height
            val bitmap=Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888)
            page.render(bitmap,null,null, RENDER_MODE_FOR_DISPLAY
            )
            page.close()
            pdfRenderer.close()
            bitmap
        }
    }

    private suspend fun downloadPdf(pdfUrl: String): File? {
        return withContext(Dispatchers.IO){
            val client= OkHttpClient()
            val request=Request.Builder()
                .url(pdfUrl)
                .build()
            val response=client.newCall(request).execute()
            if(response.isSuccessful){
                val pdfFile=File(cacheDir,"downlaod_pdf.pdf")
                val fos=FileOutputStream(pdfFile)
                response.body?.byteStream()?.use{
                    inputStream->
                    fos.use{
                        outputStream->
                        inputStream.copyTo(outputStream)
                    }
                }
                pdfFile
            }else{
                null
            }
        }
    }
}