package com.example.askhat.androidlab4.auth

import com.example.askhat.androidlab4.room.LocalStorage

class AuthRepository(private val localStorage:LocalStorage):AuthContract.AuthRepository{
    override fun addUser(email: String, password: String) {
        localStorage.addUser(email,password)
    }


}