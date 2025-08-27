package com.example.test.chapter11;

import java.util.Collections;
import java.util.List;

public class Jukebox4 {
    public static void main(String[] args) {
        new Jukebox4().go();
    }

    private void go() {
        List<SongV3> songList = MockSongs.getSongsV3();
        System.out.println(songList);   // 정렬하지 않은 songList

        Collections.sort(songList);
        System.out.println(songList);   // 제목 순으로 정렬

        // Comparator 클래스의 인스턴스를 만듦
        ArtistCompare artistCompare = new ArtistCompare();
        songList.sort(artistCompare);
        System.out.println(songList);   // 아티스트 이름 순으로 정렬
    }

    private void play() {
        List<SongV2> songList = MockSongs.getSongsV2();
        System.out.println(songList);
//        Collections.sort(songList);
        System.out.println(songList);
    }
}
