package com.example.askhat.androidlab4.core

abstract class BasePresenter<T>:IPresenter<T>{

    private var view:T ?= null

    override fun attachView(v: T) {
        view=v
    }

    override fun detachView() {
        view = null
    }

    fun getView(): T? = view
}