package com.nutmeg.mvvmlist.users

import android.os.Bundle
import androidx.activity.viewModels
import com.nutmeg.mvvmlist.R
import com.nutmeg.mvvmlist.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_user.*

@AndroidEntryPoint
class UserActivity : BaseActivity() {

    private val viewModel: UserViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.activity_user

    override fun prepareView(savedInstanceState: Bundle?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.let { viewModel.onViewLoaded(it.getInt("userId")) }
        viewModel.user.observe(this) {
            user_username.text = it.username
            user_name.text = it.name
            user_email.text = it.email
            user_address.text = it.address.city
            user_phone.text = it.phone
            user_website.text = it.website
        }
    }
}