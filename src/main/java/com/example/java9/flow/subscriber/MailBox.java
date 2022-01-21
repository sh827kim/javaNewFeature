package com.example.java9.flow.subscriber;

import com.example.java9.flow.NewsLetter;
import com.example.java9.flow.exception.StorageFullException;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class MailBox {
    private Queue<NewsLetter> savedLetters = new LinkedList<>();
    private static final int MAIL_BOX_MAX_SIZE = 10;

    public void read(NewsLetter item) {
        System.out.println("[READ] Read news, title : " + item.title());
    }

    public void save(NewsLetter item) {
        if(savedLetters.size() >=MAIL_BOX_MAX_SIZE) {
            throw new StorageFullException("Storage is full. The oldest item should be removed.");
        }

        savedLetters.offer(item);
        System.out.println("[SAVE] Mail Saved. Remaining Capacity : "+ (MAIL_BOX_MAX_SIZE- savedLetters.size()));
    }

    public void removeOldestLetter() {
        if(!savedLetters.isEmpty()) {
            savedLetters.poll();
        }
    }

    public void throwAway(NewsLetter item) {
        System.out.println("[REMOVE] Category : " + item.category().name());
    }

    public Queue<NewsLetter> letterBox() {
        return this.savedLetters;
    }
}
