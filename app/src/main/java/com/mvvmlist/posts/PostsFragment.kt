package com.mvvmlist.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mvvmlist.R
import com.mvvmlist.base.NavigationDestination
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_posts.*

@AndroidEntryPoint
class PostsFragment : Fragment(R.layout.fragment_posts) {

    private val viewModel: PostsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postsAdapter = PostsAdapter({
            viewModel.onUsernameClicked(it)
        }, {
            viewModel.onFavouritesClicked(it)
        })
        post_list_recycle_view.adapter = postsAdapter

        viewModel.onViewLoaded()

        viewModel.posts.observe(viewLifecycleOwner) {
            postsAdapter.submitList(it) { postsAdapter.notifyDataSetChanged() }
        }

        viewModel.navigation.observe(viewLifecycleOwner) {
            if (it != null) {
                when (it) {
                    is NavigationDestination.User -> {
                        findNavController().navigate(
                            PostsFragmentDirections.fromPostsFragmentToUserFragment(
                                it.userId
                            )
                        )
                    }
                }
                viewModel.doneNavigating()
            }
        }
    }

}