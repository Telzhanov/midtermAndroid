package com.example.askhat.androidlab4.login

import com.example.askhat.androidlab4.core.BasePresenter
import com.example.askhat.androidlab4.entities.User


class LoginPresenter(private val repository: LoginContract.LoginRepository) :
        BasePresenter<LoginContract.LoginView>(), LoginContract.LoginPresenter{
    override fun checkUser(email:String,password:String) {
        repository.getUsers().subscribe {
            var isFind = false
            var currentUser: User?= null
            for (user in it) {
                if (email==user.login && password == user.password) {
                    currentUser=user
                    isFind = true
                }
            }
                if (isFind){
                    getView()?.successfulLogin()
                    repository.saveUser(currentUser!!)
                }
                else {
                    getView()?.unSuccessfulLogin()
                }
            }
        }
    }
