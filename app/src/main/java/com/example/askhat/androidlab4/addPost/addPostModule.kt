package com.example.askhat.androidlab4.addPost

import org.koin.dsl.module.module

val addPostModule = module {
    factory { AddPostPresenter(get()) as AddPostContract.AddPostPresenter }
    factory { AddPostRepository(get()) as AddPostContract.AddPostRepository }
}