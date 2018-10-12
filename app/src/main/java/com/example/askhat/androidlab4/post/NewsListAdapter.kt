package com.example.askhat.androidlab4.post

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.askhat.androidlab4.NewsInfoActivity
import com.example.askhat.androidlab4.R
import com.example.askhat.androidlab4.entities.Post
import kotlinx.android.synthetic.main.news_item.view.*

class NewsListAdapter(var context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var news = ArrayList<Post>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false))
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.postTitle.text = news!![position].title
        holder.itemView.postDate.text = news!![position].content
        holder.itemView.setOnClickListener {
            val intent = Intent(context,NewsInfoActivity::class.java)
            intent.putExtra("object",news!![position])
            context.startActivity(intent)
        }
    }
    inner class NewsViewHolder(view: View): RecyclerView.ViewHolder(view)
}