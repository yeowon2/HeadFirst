package com.example.test.chapter11;

import java.util.List;

public class Jukebox6 {
    // 람다를 가지고 주크박스 코드 고쳐보기
    public static void main(String[] args) {
        new Jukebox6().go();
    }

    private void go() {
        List<SongV3> songList = MockSongs.getSongsV3();
        System.out.println(songList);

        songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
        System.out.println(songList);

        songList.sort((one, two) -> one.getArtist().compareTo(two.getArtist()));
        System.out.println(songList);

        songList.sort((one, two) -> one.getBpm() - two.getBpm());
        System.out.println(songList);

        songList.sort((one, two) -> two.getTitle().compareTo(one.getTitle()));
        System.out.println(songList);
    }
}
