package com.example.askhat.androidlab4.auth

import com.example.askhat.androidlab4.core.BasePresenter
import com.example.askhat.androidlab4.core.IPresenter

class AuthPresenter(private val repository:AuthContract.AuthRepository) :
        BasePresenter<AuthContract.AuthView>(), AuthContract.AuthPresenter{
    override fun signUpUser(email: String, password: String) {
        repository.addUser(email,password)
        getView()?.close()
    }


}