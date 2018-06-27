package com.appsdj.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> songs) {

        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = getItem(position);

        /* SET SONG ART WORK */
        // get image name
        String lib_image_holder = currentSong.getLibImage();
        // prepare the ID for the image resource
        int id = getContext().getResources().getIdentifier(lib_image_holder, "drawable", getContext().getPackageName());
        // set the resource
        ImageView library_image = (ImageView) listItemView.findViewById(R.id.lib_image);
        library_image.setImageResource(id);

        /* SET SONG TITLE */
        // Find the TextView in the song_list_item.xml layout with the ID version_name
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_title_text_view);
        // set this text on the song title TextView
        songTitleTextView.setText(currentSong.getSongTitle());

        /* SET ARTIST NAME */
        // Find the TextView in the song_list_item.xml layout with the ID version_number
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artist_name_text_view);
        // set this text on the artist name TextView
        artistNameTextView.setText(currentSong.getArtistName());

        // Return the whole song list item layout so that it can be shown in the ListView
        return listItemView;
    }

}
