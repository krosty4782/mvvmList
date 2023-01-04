package com.nutmeg.mvvmlist.posts

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nutmeg.mvvmlist.MVVMViewModelFactory
import com.nutmeg.mvvmlist.R
import com.nutmeg.mvvmlist.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_posts.*

@AndroidEntryPoint
class PostsActivity : BaseActivity() {

    private val viewModel:PostsViewModel by viewModels()
    private lateinit var adapter: PostsAdapter

    override fun getLayoutId(): Int = R.layout.activity_posts

    override fun prepareView(savedInstanceState: Bundle?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = PostsAdapter {
            viewModel.onUsernameClicked(it)
        }
        post_list_recycle_view.run {
            adapter = this@PostsActivity.adapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
        viewModel.onViewLoaded()

        viewModel.posts.observe(this) {
            adapter.submitList(it)
        }
    }
}