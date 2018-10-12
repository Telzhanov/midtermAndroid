package com.example.askhat.androidlab4.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.example.askhat.androidlab4.entities.Post
import io.reactivex.Flowable

@Dao
interface PostDao{
    @Insert
    fun addPost(post: Post)

    @Query("SELECT * from post_table")
    fun getPosts():Flowable<List<Post>>

    @Update
    fun updatePost(post:Post)
}