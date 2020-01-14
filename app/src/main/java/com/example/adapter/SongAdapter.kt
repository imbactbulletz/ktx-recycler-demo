package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Song
import com.example.ktxrecyclerdemo.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.song_list_item.*
import kotlinx.android.synthetic.main.song_list_item.view.*

class SongAdapter: ListAdapter<Song, SongAdapter.SongViewHolder>(SongAdapterDiffUtilItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_list_item, parent, false)
        val viewHolder = SongViewHolder(view)

        view.setOnClickListener {
            // itemView and containerView references point to the same object
            // listener will cause items to be looked up with findViewById each time, no matter
            // if view holder has cache or not

            viewHolder.itemView.text_song_list_item_name.text = "This is a new song name!"
            // TextView var2 = (TextView)var10000.findViewById(id.text_song_list_item_name);
            viewHolder.containerView.text_song_list_item_artist?.text = "This is a new artist!"
            //  var2 = (TextView)viewHolder.getContainerView().findViewById(id.text_song_list_item_artist);
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class SongViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun onBind(song: Song) {
            // in order to make our find view cache get called we need to access ktx properties directly
            // Now, the two lines of code will look like:
            //
            // TextView var10000 = (TextView)this._$_findCachedViewById(id.text_song_list_item_name);
            // var10000 = (TextView)this._$_findCachedViewById(id.text_song_list_item_artist);

            text_song_list_item_name.text = song.name
            text_song_list_item_artist.text = song.artist
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