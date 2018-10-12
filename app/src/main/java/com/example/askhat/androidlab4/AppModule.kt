package com.example.askhat.androidlab4

import android.arch.persistence.room.Room
import android.content.Context
import com.example.askhat.androidlab4.addPost.addPostModule
import com.example.askhat.androidlab4.auth.authModule
import com.example.askhat.androidlab4.login.loginModule
import com.example.askhat.androidlab4.post.postModule
import com.example.askhat.androidlab4.room.AppLocalDatabase
import com.example.askhat.androidlab4.room.LocalStorage
import com.example.askhat.androidlab4.room.LocalStorageImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


val appModule = module {
    single { createLocalStorage(androidContext())}
    single{ LocalStorageImpl(get()) as LocalStorage}
}

val appModules = listOf(
        appModule,
        authModule,
        loginModule,
        postModule,
        addPostModule
)

fun createLocalStorage(context: Context):AppLocalDatabase{
    return Room.databaseBuilder(context,AppLocalDatabase::class.java,"midDB").build()
}