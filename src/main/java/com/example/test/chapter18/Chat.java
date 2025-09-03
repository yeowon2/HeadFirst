package com.example.test.chapter18;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;
import static java.time.format.FormatStyle.MEDIUM;

public final class Chat {
    // 객체 필드를 final로 만든다고 해서 그 객체 안에 있는 데이터가 바뀌지 않는다고 보장할 수 있는 건 아님 (레퍼런스만 바뀌지 않음)
    // String과 LocalDateTime은 불변이기 때문에 안전
    private final String message;
    private final LocalDateTime timestamp;

    public Chat(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }

    public String toString() {
        String time = timestamp.format(ofLocalizedTime(MEDIUM));
        return time + " " + message;
    }
}
