package com.example.test.chapter11;

import java.util.ArrayList;
import java.util.List;

public class Jukebox5 {
    public static void main(String[] args) {
        new Jukebox5().go();
    }

    private void go() {
        List<SongV3> songList = MockSongs.getSongsV3();
        System.out.println(songList);

        TitleCompare titleCompare = new TitleCompare();
        songList.sort(titleCompare);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        songList.sort(artistCompare);
        System.out.println(songList);
    }
}
