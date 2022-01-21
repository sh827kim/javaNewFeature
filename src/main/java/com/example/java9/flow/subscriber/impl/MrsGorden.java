package com.example.java9.flow.subscriber.impl;

import com.example.java9.flow.NewsLetter;
import com.example.java9.flow.subscriber.NewsLetterSubscriber;

public class MrsGorden extends NewsLetterSubscriber {

    @Override
    public void behavior(NewsLetter item) {
        switch (item.category()) {
            case ECONOMY -> {
                read(item);
                save(item);
            }
            case TECHNOLOGY, POLITICS -> read(item);
            default -> throwAway(item);
        }
    }

    @Override
    public String subscriberName() {
        return "Kelly Gorden";
    }

}
