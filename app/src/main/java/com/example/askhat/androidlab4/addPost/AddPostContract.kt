package com.example.askhat.androidlab4.addPost

import com.example.askhat.androidlab4.core.IPresenter
import com.example.askhat.androidlab4.core.IView

interface AddPostContract{

    interface AddPostPresenter:IPresenter<AddPostView>{
        fun addPost(title:String, desc:String)
    }

    interface AddPostView:IView<AddPostPresenter>{

    }

    interface AddPostRepository{
        fun addPost(title:String,desc:String)
    }
}