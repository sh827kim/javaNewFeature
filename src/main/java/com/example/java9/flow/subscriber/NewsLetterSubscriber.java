package com.example.java9.flow.subscriber;

import com.example.java9.flow.NewsLetter;
import com.example.java9.flow.exception.StorageFullException;

import java.util.concurrent.Flow;

public abstract class NewsLetterSubscriber extends MailBox implements Flow.Subscriber<NewsLetter>{

    private Flow.Subscription subscription;
    private static final long REQUEST = Long.MAX_VALUE;

    public abstract void behavior(NewsLetter item);

    public abstract String subscriberName();

    @Override
    public void onNext(NewsLetter item) {
        behavior(item);
        subscription.request(REQUEST);
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(REQUEST);
    }
    @Override
    public void onError(Throwable throwable) {
        if(throwable instanceof StorageFullException storageFullException) {
            removeOldestLetter();
            System.out.println("[ Dear " + subscriberName() + ", Error occured! : " + storageFullException.getMessage() + " ]");
        }
    }

    @Override
    public void onComplete() {
        System.out.println("Dear " + subscriberName() + ", Thank you for subscribe our letters, but it's time to say good bye...");
    }
}
