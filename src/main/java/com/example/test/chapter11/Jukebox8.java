package com.example.test.chapter11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jukebox8 {
    public static void main(String[] args) {
        new Jukebox8().go();
    }

    private void go() {
        List<SongV3> songList = MockSongs.getSongsV3();
        System.out.println(songList);

        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        Set<SongV3> songSet = new HashSet<>(songList);
        System.out.println(songSet);
    }
}
