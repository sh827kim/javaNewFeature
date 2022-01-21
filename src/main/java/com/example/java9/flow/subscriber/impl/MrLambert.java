package com.example.java9.flow.subscriber.impl;


import com.example.java9.flow.NewsLetter;
import com.example.java9.flow.subscriber.NewsLetterSubscriber;

public class MrLambert extends NewsLetterSubscriber {

    @Override
    public void behavior(NewsLetter item) {
        switch (item.category()) {
            case TECHNOLOGY, SPORTS, ENTERTAINMENTS -> {
                read(item);
                save(item);
            }
            case ECONOMY -> read(item);
            default -> throwAway(item);
        }
    }

    @Override
    public String subscriberName() {
        return "Daniel Lambert";
    }
}
