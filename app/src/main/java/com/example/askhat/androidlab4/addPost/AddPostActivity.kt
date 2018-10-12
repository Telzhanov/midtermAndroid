package com.example.askhat.androidlab4.addPost

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.askhat.androidlab4.R
import kotlinx.android.synthetic.main.activity_add_post.*
import org.koin.android.ext.android.inject

class AddPostActivity : AppCompatActivity(),AddPostContract.AddPostView {
    override val presenter:AddPostContract.AddPostPresenter by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        setContentView(R.layout.activity_add_post)
        addButton.setOnClickListener {
            presenter.addPost(titlePost.text.toString(),descPost.text.toString())
            finish()
        }
    }
}
