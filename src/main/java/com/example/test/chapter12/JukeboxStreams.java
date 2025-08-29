package com.example.test.chapter12;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class JukeboxStreams {
    public static void main(String[] args) {
        List<Song> songs = new Songs().getSongs();

        List<Song> rockSongs = songs.stream()
//                .filter(song -> song.getGenre().contains("Rock"))
//                .filter(song -> song.getArtist().equals("The Beatles"))
//                .filter(song -> song.getTitle().startsWith("H"))
                .filter(song -> song.getYear() >= 1995)
                .collect(toList());

//        System.out.println(rockSongs);

        List<String> geners = songs.stream()
                .map(song -> song.getGenre())
                .distinct()
                // import static java.util.stream.Collectors.toList; 필요 -> geners 변수 수정 불가
                .collect(toList());

        System.out.println(geners);
    }
}
