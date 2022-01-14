package com.example.java9.flow.subscriber;

import com.example.java9.flow.NewsLetter;
import com.example.java9.flow.exception.StorageFullException;

import java.util.LinkedList;
import java.util.Queue;

public class MailBox {
    private Queue<NewsLetter> savedLetters = new LinkedList<>();
    private static final int MAIL_BOX_MAX_SIZE = 10;

    public void read(NewsLetter item) {
    //    System.out.println("========= Read news letter... ==========");
    //    System.out.println(item.title());
    //    System.out.println("========= Read Done. ==========");
    }

    public void save(NewsLetter item) {
        if(savedLetters.size() >=MAIL_BOX_MAX_SIZE) {
            throw new StorageFullException("Storage is full. The oldest item should be removed.");
        }
    //    System.out.println("========= Save news letter... ==========");
        savedLetters.offer(item);

    //    System.out.println("========= Save Done. ==========");
    }

    public void removeOldestLetter() {
        if(!savedLetters.isEmpty()) {
            savedLetters.poll();
        }
    }

    public void throwAway(NewsLetter item) {
    //    System.out.println("========= This news letter will be removed ==========");
    //    System.out.println("PublishAt : " + item.publishAt().toString());
     //   System.out.println("Author : " + item.author());
     //   System.out.println("========= Remove Done. ==========");
    }

    public Queue<NewsLetter> letterBox() {
        return this.savedLetters;
    }
}
