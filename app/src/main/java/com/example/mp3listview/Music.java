package com.example.mp3listview;

import android.media.MediaPlayer;

public class Music {
    String songName;
    String artistName;
    int albumCover;
    int song;

    public Music (String songName, String artistName, int albumCover, int song)
    {
        this.songName = songName;
        this.artistName = artistName;
        this.albumCover = albumCover;
        this.song = song;
    }
}

