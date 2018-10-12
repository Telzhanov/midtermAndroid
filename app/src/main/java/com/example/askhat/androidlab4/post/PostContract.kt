package com.example.askhat.androidlab4.post

import com.example.askhat.androidlab4.core.IPresenter
import com.example.askhat.androidlab4.core.IView
import com.example.askhat.androidlab4.entities.Post
import io.reactivex.Observable

interface PostContract{

    interface PostView:IView<PostPresenter>{
        fun setPosts(posts:ArrayList<Post>)
    }

    interface PostPresenter:IPresenter<PostView>{
        fun getPosts(status:Boolean)
    }
    interface PostRepository{
        fun getToDo(): Observable<ArrayList<Post>>
        fun getDone():Observable<ArrayList<Post>>
    }
}