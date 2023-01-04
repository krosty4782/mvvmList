package com.nutmeg.mvvmlist.posts

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.nutmeg.mvvmlist.databinding.ViewPostsItemBinding
import kotlinx.android.synthetic.main.view_posts_item.view.*

class PostsAdapter(private val onUsernameClicked: (Int) -> Unit) : ListAdapter<PostsModel, PostsViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(ViewPostsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.username.setOnClickListener {
            getItem(position)?.let { onUsernameClicked(it.userId) }
        }
        return holder.bind(getItem(position))
    }

    override fun onCurrentListChanged(
        previousList: MutableList<PostsModel>,
        currentList: MutableList<PostsModel>
    ) {
        Log.e("error", "list changed")
        super.onCurrentListChanged(previousList, currentList)
    }

    private class DiffUtilCallback : DiffUtil.ItemCallback<PostsModel>() {

        override fun areItemsTheSame(oldItem: PostsModel, newItem: PostsModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: PostsModel, newItem: PostsModel): Boolean {
            return oldItem.body == newItem.body
        }
    }
}