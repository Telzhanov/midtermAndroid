package com.example.askhat.androidlab4.post

import org.koin.dsl.module.module

val postModule = module {
    factory { PostPresenter(get()) as PostContract.PostPresenter }
    factory { PostRepository(get()) as PostContract.PostRepository }
}