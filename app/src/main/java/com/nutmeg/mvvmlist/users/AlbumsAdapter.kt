package com.nutmeg.mvvmlist.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nutmeg.core.domain.models.Album
import com.nutmeg.mvvmlist.databinding.ViewUserAlbumBinding

class AlbumsAdapter() : RecyclerView.Adapter<AlbumViewHolder>() {
    private var albums = mutableListOf<Album>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(
            ViewUserAlbumBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) =
        holder.bind(albums[position])

    override fun getItemCount() = albums.size

    fun addAll(albums: List<Album>) {
        this.albums.clear()
        this.albums.addAll(albums)
        notifyDataSetChanged()
    }

}

class AlbumViewHolder(private val binding: ViewUserAlbumBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(album: Album) {
        binding.title.text = album.title
    }
}