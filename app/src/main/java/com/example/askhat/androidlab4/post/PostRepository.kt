package com.example.askhat.androidlab4.post

import com.example.askhat.androidlab4.entities.Post
import com.example.askhat.androidlab4.room.LocalStorage
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.observable.ObservableCache
import io.reactivex.schedulers.Schedulers

class PostRepository(private val localStorage:LocalStorage): PostContract.PostRepository{
    override fun getToDo(): Observable<ArrayList<Post>> {
        return localStorage.getPosts()
                .map{
                    var toDo = ArrayList<Post>()
                    for (post in it){
                        if (post.status == false){
                            toDo.add(post)
                        }
                    }
                    toDo
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getDone():Observable<ArrayList<Post>>{
        return localStorage.getPosts()
                .map {
                    var done = ArrayList<Post>()
                    for (post in it){
                        if (post.status == true){
                            done.add(post)
                        }
                    }
                    done
                }
    }
}