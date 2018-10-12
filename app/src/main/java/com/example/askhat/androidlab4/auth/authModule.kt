package com.example.askhat.androidlab4.auth

import org.koin.dsl.module.module

val authModule = module {
    factory { AuthPresenter(get()) as AuthContract.AuthPresenter }
    factory { AuthRepository(get()) as AuthContract.AuthRepository }
}