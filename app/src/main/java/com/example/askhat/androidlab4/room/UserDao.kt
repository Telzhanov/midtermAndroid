package com.example.askhat.androidlab4.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.provider.ContactsContract
import com.example.askhat.androidlab4.entities.User
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
interface UserDao{

    @Insert
    fun addUser(user: User)

    @Query("SELECT * from user_table")
    fun getUsers(): Maybe<List<User>>
}