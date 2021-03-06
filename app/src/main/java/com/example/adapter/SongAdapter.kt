package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Song
import com.example.ktxrecyclerdemo.R
import kotlinx.android.synthetic.main.song_list_item.view.*

class SongAdapter: ListAdapter<Song, SongAdapter.SongViewHolder>(SongAdapterDiffUtilItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_list_item, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class SongViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(song: Song) {
            itemView.text_song_list_item_name.text = song.name
            itemView.text_song_list_item_artist.text = song.artist
        }
    }

    companion object SongAdapterDiffUtilItemCallback: DiffUtil.ItemCallback<Song>() {
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem == newItem
        }
    }
}