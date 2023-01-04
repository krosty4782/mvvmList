package com.nutmeg.mvvmlist.users

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.nutmeg.mvvmlist.R
import com.nutmeg.mvvmlist.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity : BaseActivity() {

    private val viewModel:UserViewModel by viewModels()

    override fun getLayoutId(): Int  = R.layout.activity_user

    override fun prepareView(savedInstanceState: Bundle?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.let { viewModel.onViewLoaded(it.getInt("userId")) }
        viewModel.user.observe(this) {
            Log.d("this is my user", it.toString())
        }
    }
}