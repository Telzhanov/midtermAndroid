package com.example.askhat.androidlab4.post

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import com.example.askhat.androidlab4.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    var pager: CategoryPageAdapter ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbarNews)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp)
            setDisplayShowTitleEnabled(false)
        }
        pager = CategoryPageAdapter(supportFragmentManager)
        categoryPager.adapter = pager
        tabCategory.setupWithViewPager(categoryPager)
    }

}
