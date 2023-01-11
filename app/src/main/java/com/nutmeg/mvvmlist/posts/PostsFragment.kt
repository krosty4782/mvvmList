package com.nutmeg.mvvmlist.posts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nutmeg.mvvmlist.R
import com.nutmeg.mvvmlist.base.NavigationDestination
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_posts.*

@AndroidEntryPoint
class PostsFragment : Fragment(R.layout.fragment_posts) {

    private val viewModel: PostsViewModel by viewModels()
    private lateinit var adapter: PostsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PostsAdapter({
            viewModel.onUsernameClicked(it)
        }, {
            viewModel.onFavouritesClicked(it)
        })
        post_list_recycle_view.run {
            adapter = this@PostsFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
        viewModel.onViewLoaded()

        viewModel.posts.observe(viewLifecycleOwner) {
            adapter.submitList(it) { adapter.notifyDataSetChanged() }
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