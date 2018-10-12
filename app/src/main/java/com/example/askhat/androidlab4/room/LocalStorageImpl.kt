package com.example.askhat.androidlab4.room

import com.example.askhat.androidlab4.entities.Post
import com.example.askhat.androidlab4.entities.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class LocalStorageImpl(private var appLocalDatabase: AppLocalDatabase):LocalStorage{
    var user:User ?= null
    override fun addPost(title: String, content: String) {
        Observable.fromCallable {
            appLocalDatabase.postDao().addPost(Post(title,content,user?.id!!,false))
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun getUsers(): Observable<List<User>> {
        return appLocalDatabase.userDao().getUsers()
                .toObservable()
    }

    override fun getPosts(): Observable<ArrayList<Post>> {
        return  appLocalDatabase.postDao().getPosts()
                .map{
                    var posts = ArrayList<Post>()
                    for (post in it){
                        if (post.userId == user?.id!!){
                            posts.add(post)
                        }
                    }
                    posts
                }
                .toObservable()
    }

    override fun addUser(email: String, password: String) {
        Observable.fromCallable {
            appLocalDatabase.userDao().addUser(User(email,password))
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun saveCurrentUser(user:User) {
        this.user = user
    }

    override fun updatePost(post: Post) {
        Observable.fromCallable {
            appLocalDatabase.postDao().updatePost(post)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }
}