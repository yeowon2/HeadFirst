package com.example.test.chapter11;


public class SongV3 implements Comparable<SongV3> {
    private String title;
    private String artist;
    private int bpm;

    public int compareTo(SongV3 song) {
        return title.compareTo(song.getTitle());
    }

    SongV3(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return title;
    }
}
