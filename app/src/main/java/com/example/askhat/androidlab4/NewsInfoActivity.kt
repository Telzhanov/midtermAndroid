package com.example.askhat.androidlab4

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import com.example.askhat.androidlab4.entities.Post
import com.example.askhat.androidlab4.room.LocalStorage
import kotlinx.android.synthetic.main.activity_news_info.*
import org.koin.android.ext.android.inject

class NewsInfoActivity : AppCompatActivity() {
    val localStorage:LocalStorage by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_info)
        var news= intent.getSerializableExtra("object") as Post
        titlePost.setText(news.title)
        descPost.setText(news.content)
        doneButton.setOnClickListener {
            news.title = titlePost.text.toString()
            news.content = descPost.text.toString()
            news.status = true
            localStorage.updatePost(news)
            finish()
        }
    }
}
