package com.nutmeg.mvvmlist.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import com.nutmeg.mvvmlist.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_user.*

@AndroidEntryPoint
class UserFragment : Fragment(R.layout.fragment_user) {
    private val args: UserFragmentArgs by navArgs()
    private val viewModel: UserViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val albumsAdapter = AlbumsAdapter()
        viewModel.onViewLoaded(args.userId)
        configAlbumsList(albumsAdapter)

        viewModel.albums.observe(viewLifecycleOwner) {
            albumsAdapter.addAll(it)
        }

        viewModel.user.observe(viewLifecycleOwner) {
            user_username.text = it.username
            user_name.text = it.name
            user_email.text = it.email
            user_address.text = it.address.city
            user_phone.text = it.phone
            user_website.text = it.website
        }
    }

    private fun configAlbumsList(albumsAdapter: AlbumsAdapter) {
        user_albums.adapter = albumsAdapter
        user_albums.addItemDecoration(
            DividerItemDecoration(
                user_albums.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }
}