package com.example.java9.flow;

import java.time.LocalDateTime;

public record NewsLetter(LocalDateTime publishAt, Field field, String author, String title) {

    public enum Field {
        ECONOMY,
        ENTERTAINMENTS,
        POLITICS,
        SPORTS,
        TECHNOLOGY
    }
}
