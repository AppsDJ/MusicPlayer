package com.appsdj.musicplayer;

import java.io.Serializable;

public class Song implements Serializable {

    private String songTitle;
    private String artistName;
    private String libImage;
    private String playImage;

    public Song(String songTitle, String artistName, String libImage, String playImage) {
        this.songTitle = songTitle;
        this.artistName = artistName;
        this.libImage = libImage;
        this.playImage = playImage;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setLibImage(String libImage) { this.libImage = libImage; }

    public void setPlayImage(String playImage) { this.playImage = playImage; }

    public String getSongTitle() { return songTitle; }

    public String getArtistName() { return artistName; }

    public String getLibImage() { return libImage; }

    public String getPlayImage() { return playImage; }
}
