package com.example.askhat.androidlab4.addPost

import com.example.askhat.androidlab4.core.BasePresenter
import com.example.askhat.androidlab4.post.PostContract
import com.example.askhat.androidlab4.post.PostRepository

class AddPostPresenter(private val repository: AddPostContract.AddPostRepository):
        AddPostContract.AddPostPresenter,BasePresenter<AddPostContract.AddPostView>(){
    override fun addPost(title: String, desc: String) {
        repository.addPost(title,desc)
    }


}