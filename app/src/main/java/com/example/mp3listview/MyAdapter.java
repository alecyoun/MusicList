package com.example.mp3listview;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Mayank Sanghvi on 25-11-2017.
 */

public class MyAdapter extends BaseAdapter {

    public ArrayList<Music> listMusic;
    private Context context;
    MediaPlayer mp;

    public MyAdapter(Context context, ArrayList<Music> listMusic) {
        this.context = context;
        this.listMusic = listMusic;
    }

    @Override
    public int getCount() {
        return listMusic.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row;
        final ListViewHolder listViewHolder;
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row,parent,false);
            listViewHolder = new ListViewHolder();
            listViewHolder.tvSongName = row.findViewById(R.id.songname);
            listViewHolder.tvArtistName = row.findViewById(R.id.artistname);
            listViewHolder.ivAlbumCover = row.findViewById(R.id.albumimage);
            listViewHolder.ibPlayButton = row.findViewById(R.id.playbutton);
            row.setTag(listViewHolder);
        }
        else
        {
            row=convertView;
            listViewHolder= (ListViewHolder) row.getTag();
        }
        final Music music = listMusic.get(position);

        mp = MediaPlayer.create(context, music.song);
        mp.setLooping(false);
        listViewHolder.tvSongName.setText(music.songName);
        listViewHolder.tvArtistName.setText(music.artistName);
        listViewHolder.ivAlbumCover.setImageResource(music.albumCover);
        listViewHolder.ibPlayButton.setBackgroundResource(R.drawable.play);
        listViewHolder.ibPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                if(!mp.isPlaying())
                {
                    mp.start();
                    listViewHolder.ibPlayButton.setBackgroundResource(R.drawable.pause);
                }
                else
                {
                    mp.pause();
                    listViewHolder.ibPlayButton.setBackgroundResource(R.drawable.play);
                }
            }
        });

        return row;
    }

}