package com.android.flickrdroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchJson(this)
    }

    fun fetchJson(context: Context) {
        val client = OkHttpClient()
        val url =
            " https://www.flickr.com/services/rest/?method=flickr.photos.getRecent&api_key=&format=json&nojsoncallback=1&api_sig="
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()

                val gson = GsonBuilder().create()

                println(body)

                val homeFeed = gson.fromJson(body, FlickrPhotos::class.java)

                runOnUiThread{
                    gridView_main.adapter = MainAdapter(context,homeFeed.photos)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println(e)
            }
        })

    }

}