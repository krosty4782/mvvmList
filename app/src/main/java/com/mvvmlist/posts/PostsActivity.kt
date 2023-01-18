package com.mvvmlist.posts


import android.os.Bundle
import com.mvvmlist.R
import com.mvvmlist.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostsActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_posts

    override fun prepareView(savedInstanceState: Bundle?) {}

}