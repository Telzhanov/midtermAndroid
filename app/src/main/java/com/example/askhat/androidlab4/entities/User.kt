package com.example.askhat.androidlab4.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
@Entity(tableName = "user_table")
data class User(
        @ColumnInfo(name = "login") var login:String,
        @ColumnInfo(name = "password") var password:String){
    @PrimaryKey(autoGenerate = true)  var id:Int?=null
    @Ignore constructor(id:Int, login:String, password: String):this(login,password){
        this.id = id
    }
}