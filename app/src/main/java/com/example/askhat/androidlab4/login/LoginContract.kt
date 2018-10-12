package com.example.askhat.androidlab4.login

import com.example.askhat.androidlab4.core.IPresenter
import com.example.askhat.androidlab4.core.IView
import com.example.askhat.androidlab4.entities.User
import io.reactivex.Observable

interface LoginContract{

    interface LoginView:IView<LoginPresenter>{
        fun successfulLogin()
        fun unSuccessfulLogin()
    }

    interface LoginPresenter:IPresenter<LoginView>{
        fun checkUser(email:String, password:String)
    }

    interface LoginRepository{
        fun getUsers(): Observable<ArrayList<User>>
        fun saveUser(user:User)
    }
}