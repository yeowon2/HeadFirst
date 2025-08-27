package com.example.test.chapter11;


public class SongV4 implements Comparable<SongV4> {
    private String title;
    private String artist;
    private int bpm;

    public boolean equals(Object aSong) {
        SongV4 other = (SongV4) aSong;
        return title.equals(other.getTitle());
    }

    public int hashCode() {
        return title.hashCode();
    }

    public int compareTo(SongV4 song) {
        return title.compareTo(song.getTitle());
    }

    SongV4(String title, String artist, int bpm) {
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
