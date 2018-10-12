package com.example.askhat.androidlab4.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.askhat.androidlab4.entities.Post
import com.example.askhat.androidlab4.entities.User

@Database(entities = arrayOf(User::class, Post::class),version = 1)
abstract class AppLocalDatabase: RoomDatabase() {
    abstract fun userDao():UserDao
    abstract fun postDao():PostDao
}