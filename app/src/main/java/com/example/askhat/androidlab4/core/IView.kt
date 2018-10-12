package com.example.askhat.androidlab4.core

interface IView<out V>{
    val presenter:V
}