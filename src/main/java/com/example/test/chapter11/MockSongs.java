package com.example.test.chapter11;

import java.util.ArrayList;
import java.util.List;

// 모의 코드
public class MockSongs {
    // 이 클래스에는 인스턴스 필드가 없고, 인스턴스 필드를 쓸 필요도 없기 때문에 정적 메서드로 생성
    public static List<String> getSongStrings() {
        List<String> songs = new ArrayList<>();
        songs.add("Good Luck! Babe");
        songs.add("Ukon");
        songs.add("party 4 u");
        songs.add("Alonica");
        songs.add("blue");
        songs.add("2+2=4");

        return songs;
    }

    public static List<SongV2> getSongsV2() {
        List<SongV2> songs = new ArrayList<>();

        songs.add(new SongV2("Good Luck! Babe", "Charlie", 100));
        songs.add(new SongV2("Ukon", "Justin Bieber", 80));
        songs.add(new SongV2("party 4 u", "Charlie XCX", 110));
        songs.add(new SongV2("Alonica", "Lany", 65));
        songs.add(new SongV2("blue", "yung kai", 75));
        songs.add(new SongV2("2+2=4", "minoe", 91));

        return songs;
    }
}
