package com.example.askhat.androidlab4.login

import org.koin.dsl.module.module

val loginModule = module {
    factory { LoginRepository(get()) as LoginContract.LoginRepository }
    factory { LoginPresenter(get()) as LoginContract.LoginPresenter}
}