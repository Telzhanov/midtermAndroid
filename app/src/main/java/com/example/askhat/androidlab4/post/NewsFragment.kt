package com.example.askhat.androidlab4.post

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.askhat.androidlab4.R
import com.example.askhat.androidlab4.addPost.AddPostActivity
import com.example.askhat.androidlab4.entities.Post
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news_fragment.*
import kotlinx.android.synthetic.main.news_fragment.view.*
import org.koin.android.ext.android.inject

class NewsFragment: Fragment(),PostContract.PostView{
    var context:MainActivity ?= null
    var adapter :NewsListAdapter?=null
    override fun setPosts(posts: ArrayList<Post>) {
        adapter?.news = posts
        adapter?.notifyDataSetChanged()
    }
    override val presenter:PostContract.PostPresenter by inject()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.news_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getPosts(false)
        adapter = NewsListAdapter(context!!)
        if (context?.resources?.configuration?.orientation== Configuration.ORIENTATION_LANDSCAPE) {
            view.newsList.layoutManager = GridLayoutManager(context,2)
            view.newsList.adapter = adapter
        }
        else{
            view.newsList.layoutManager = LinearLayoutManager(context)
            view.newsList.adapter = adapter
        }
        addPost.setOnClickListener{
            val intent = Intent(context,AddPostActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        presenter.attachView(this)
        this.context = context as MainActivity
    }
}

const val ADD_POST_CODE = 12