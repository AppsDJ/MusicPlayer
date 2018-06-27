package com.appsdj.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerActivity extends AppCompatActivity {

    private int songID;
    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent extras = getIntent();
        // get the ID (or position in the list) of the song in library which was clicked
        songID = getIntent().getIntExtra("SongID", 0);
        // get the
        songs = (ArrayList<Song>) extras.getSerializableExtra("LIST");

        /* SET SONG ART WORK */
        String play_image_holder = songs.get(songID).getPlayImage();
        // prepare the ID for the image resource
        int id = getResources().getIdentifier(play_image_holder, "drawable", getPackageName());
        // get the image view holder
        ImageView imagePlayingNow = (ImageView) findViewById(R.id.image_playing_now);
        // set image on the song playing ImageView
        imagePlayingNow.setImageResource(id);

        /* SET SONG TITLE */
        TextView songTitleTextView = (TextView) findViewById(R.id.song_playing);
        // set text on the song title TextView
        songTitleTextView.setText(songs.get(songID).getSongTitle());

        /* SET ARTIST NAME */
        TextView artistNameTextView = (TextView) findViewById(R.id.artist_name_playing);
        // set text on the artist name TextView
        artistNameTextView.setText(songs.get(songID).getArtistName());

        // return to Library
        ImageButton returnToLibrary = (ImageButton) findViewById(R.id.return_to_library);
        // Set a click listener on ImageButton
        returnToLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(PlayerActivity.this, MainActivity.class);
                startActivity(libraryIntent);
            }
        });

    }
}
