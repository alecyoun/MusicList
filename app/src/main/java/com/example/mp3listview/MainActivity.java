package com.example.mp3listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Music> al;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);

        al = new ArrayList<>();
        al.add(new Music("Peaches", "Justin Bieber", R.drawable.album1, R.raw.music1));
        al.add(new Music("Wrong", "The Kid Laroi", R.drawable.album2, R.raw.music2));
        al.add(new Music("Beautiful Mistakes", "Maroon 5", R.drawable.album3, R.raw.music3));

        adapter = new MyAdapter(this, al);
        lv.setAdapter(adapter);
    }
}