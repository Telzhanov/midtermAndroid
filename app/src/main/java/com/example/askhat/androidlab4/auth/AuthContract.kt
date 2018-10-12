package com.example.askhat.androidlab4.auth

import com.example.askhat.androidlab4.core.IPresenter
import com.example.askhat.androidlab4.core.IView

interface AuthContract{

    interface AuthView:IView<AuthPresenter>{
        fun close()
    }

    interface AuthPresenter:IPresenter<AuthView>{
        fun signUpUser(email:String, password:String)

    }

    interface AuthRepository{
        fun addUser(email:String,password:String)
    }

}