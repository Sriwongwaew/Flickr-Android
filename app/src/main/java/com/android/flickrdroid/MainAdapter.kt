package com.android.flickrdroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_row.view.*

class MainAdapter(private val context: Context, private val photos: Photos) : BaseAdapter() {

    override fun getItem(p0: Int): Any {
        return photos.photo[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return photos.photo.size
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val photo = photos.photo.get(p0)

        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var imageView = inflater.inflate(R.layout.image_row, null)

        Picasso.get()
            .load("https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg")
            .into(imageView.imageView_flicker_startpage)
        return imageView
    }

}
