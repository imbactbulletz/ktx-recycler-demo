package com.example.ktxrecyclerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.domain.Song

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songList = createSongList()
    }

    fun createSongList(): List<Song> {
        val songList = mutableListOf<Song>()
        songList.add(Song("Right Here Right Now", "Fatboy Slim"))
        songList.add(Song("Pjanoo", "Eric Prydz"))
        songList.add(Song("Lola's Theme", "The Shapeshifters"))
        songList.add(Song("Children", "Robert Miles"))
        songList.add(Song("9pm [Till I Come]", "ATB"))
        songList.add(Song("Greece 2000", "Three Drivers"))
        songList.add(Song("Touch Me", "Rui Da Silva"))
        songList.add(Song("You Don't Know Me", "Jax Jones"))
        songList.add(Song("Galvanize", "The Chemical Brothers"))
        songList.add(Song("At The River", "Groove Armada"))
        songList.add(Song("Alright  ", "Red Carpet"))
        songList.add(Song("Offshore", "Chicane"))
        songList.add(Song("Rej", "Ame"))
        return songList
    }
}
