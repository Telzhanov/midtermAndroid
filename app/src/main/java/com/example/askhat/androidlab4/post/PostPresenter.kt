package com.example.askhat.androidlab4.post

import com.example.askhat.androidlab4.core.BasePresenter

class PostPresenter(private  val repository: PostContract.PostRepository):
        PostContract.PostPresenter, BasePresenter<PostContract.PostView>(){
    override fun getPosts(status:Boolean) {
        if (status) {
            repository.getDone().subscribe {
                getView()?.setPosts(it)
            }
        }
        else{
            repository.getToDo().subscribe {
                getView()?.setPosts(it)
            }
        }

    }

}