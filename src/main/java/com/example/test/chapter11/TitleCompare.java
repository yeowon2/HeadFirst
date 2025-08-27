package com.example.test.chapter11;

import java.util.Comparator;

public class TitleCompare implements Comparator<SongV3> {
    @Override
    public int compare(SongV3 one, SongV3 two) {
        return one.getTitle().compareTo(two.getTitle());
    }
}
