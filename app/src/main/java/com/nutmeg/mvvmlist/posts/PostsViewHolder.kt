package com.nutmeg.mvvmlist.posts

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.nutmeg.mvvmlist.R
import com.nutmeg.mvvmlist.databinding.ViewPostsItemBinding

class PostsViewHolder(private val binding: ViewPostsItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: PostsModel) {
        binding.apply {
            username.text = model.username
            title.text = model.title
            body.text = model.body
            favourite.setImageResource( if (model.isFavourite)  R.drawable.ic_fav_enabled else R.drawable.ic_fav_disabled)
        }
    }
}