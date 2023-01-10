package com.nutmeg.mvvmlist.posts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nutmeg.mvvmlist.databinding.ViewPostsItemBinding
import kotlinx.android.synthetic.main.view_posts_item.view.*

class PostsAdapter(
    private val onUsernameClicked: (Int) -> Unit,
    private val onFavouritesClicked: (PostsModel) -> Unit
) : ListAdapter<PostsModel, PostsViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            ViewPostsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.username.setOnClickListener {
            getItem(position)?.let { onUsernameClicked(it.userId) }
        }
        holder.itemView.favourite.setOnClickListener {
            getItem(position)?.let { onFavouritesClicked(it) }
        }
        return holder.bind(getItem(position))
    }

    override fun onCurrentListChanged(
        previousList: MutableList<PostsModel>,
        currentList: MutableList<PostsModel>
    ) {
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