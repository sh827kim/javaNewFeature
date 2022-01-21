package com.example.java9.flow;

import java.time.LocalDateTime;

public record NewsLetter(LocalDateTime publishAt, Category category, String author, String title) {

    public enum Category {
        ECONOMY,
        ENTERTAINMENTS,
        POLITICS,
        SPORTS,
        TECHNOLOGY
    }
}
