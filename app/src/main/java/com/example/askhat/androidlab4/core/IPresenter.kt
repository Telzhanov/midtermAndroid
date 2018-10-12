package com.example.askhat.androidlab4.core

interface IPresenter<T>{

    fun attachView(v:T)

    fun detachView()

}