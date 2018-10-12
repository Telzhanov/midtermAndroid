package com.example.askhat.androidlab4.post

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class CategoryPageAdapter(fr: FragmentManager): FragmentPagerAdapter(fr){
    val newsFragment = NewsFragment()
    val categoryFragment = CategoryFragment()
    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return newsFragment
            }
            else-> return categoryFragment
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0->return "Recent news"
            1->return "Categories"
            else->return null
        }
    }

}