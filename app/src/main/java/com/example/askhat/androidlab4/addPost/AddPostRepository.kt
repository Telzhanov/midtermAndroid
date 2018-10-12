package com.example.askhat.androidlab4.addPost

import com.example.askhat.androidlab4.room.LocalStorage

class AddPostRepository(private val localStorage:LocalStorage):AddPostContract.AddPostRepository{
    override fun addPost(title: String, desc: String) {
        localStorage.addPost(title,desc)
    }


}