package com.nutmeg.mvvmlist.posts


import android.os.Bundle
import com.nutmeg.mvvmlist.R
import com.nutmeg.mvvmlist.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PostsActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_posts

    override fun prepareView(savedInstanceState: Bundle?) {}

}