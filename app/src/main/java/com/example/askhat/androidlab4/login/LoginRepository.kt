package com.example.askhat.androidlab4.login

import com.example.askhat.androidlab4.entities.User
import com.example.askhat.androidlab4.room.LocalStorage
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginRepository(private val localStorage:LocalStorage): LoginContract.LoginRepository{
    override fun getUsers(): Observable<ArrayList<User>> {
        return localStorage.getUsers().map { it as ArrayList<User> }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun saveUser(user:User) {
        localStorage.saveCurrentUser(user)
    }


}