package com.android.flickrdroid

class FlickrPhotos (val photos : Photos)

class Photos(val page: Int, val pages: Int, val perpage :  Int, val total: Int, val photo: List<Photo>)

class Photo (val id: Long, val owner: String, val secret: String, val server : Int, val farm : Int, val title: String)