package com.appsdj.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Take on me", "A-ha", "aha_s", "aha_l"));
        songs.add(new Song("October", "U2", "u2october_s", "u2october_l"));
        songs.add(new Song("Alive and Kicking", "Simple Minds", "simpleminds_alive_s", "simpleminds_alive_l"));
        songs.add(new Song("Dreamer", "Super Tramp", "supertramp_dreamer_s", "supertramp_dreamer_l"));
        songs.add(new Song("Five miles out", "Mike Oldfield", "mikeoldfield_five_s", "mikeoldfield_five_l"));

        SongAdapter adapter = new SongAdapter(this, songs);
        listView = (ListView) findViewById(R.id.list_main);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            // The code in this method will be executed when a Song View is clicked
            @Override
            public void onItemClick(AdapterView <? > arg0, View view, int position, long id) {

                Intent numbersIntent = new Intent(MainActivity.this, PlayerActivity.class);
                // pass the ID (or position) of a song in the list to the player activity
                numbersIntent.putExtra("SongID", position);
                // pass the entire song list to the player activity
                numbersIntent.putExtra("LIST", (Serializable) songs);
                startActivity(numbersIntent);
            }
        });
    }

}
