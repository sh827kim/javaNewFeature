package com.example.java9.flow;


import com.example.java9.flow.subscriber.impl.MrLambert;
import com.example.java9.flow.subscriber.impl.MrsGorden;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FlowExample {
    public static void main(String[] args) throws InterruptedException {
        /* Publisher 생성 */
        var newsLetterPublisher = new SubmissionPublisher<NewsLetter>();
        var subscribers = subscribers();
        var newsLetterList = getNewsLetterList();
        var randomRange = newsLetterList.size()-1;
        var random = new Random();

        var publishCount = 0;

        subscribers.forEach(newsLetterPublisher::subscribe);

        while(!newsLetterPublisher.isClosed()) {
            /* 랜덤으로 뉴스 데이터를 가져와서 발행. */
            var newsLetter = newsLetterList.get(random.nextInt(randomRange));
            newsLetterPublisher.submit(new NewsLetter(LocalDateTime.now(), newsLetter.field(), newsLetter.author(), newsLetter.title()));

            Thread.sleep(10);

            /* Exception 발생으로 인해 구독 해지가 된 구독자는 다시 구독 처리 */
            subscribers.stream().filter(subscriber -> !newsLetterPublisher.isSubscribed(subscriber))
                    .forEach(unsubscribed -> {
                        System.out.println("Reclaim subscription for " + unsubscribed.getClass().getName());
                        newsLetterPublisher.subscribe(unsubscribed);
                    });

            publishCount++;

            if(publishCount >= 40) {
                newsLetterPublisher.close();
            }
        }
    }

    private static List<Flow.Subscriber<NewsLetter>> subscribers() {
        return List.of(new MrsGorden(), new MrLambert());
    }

    private static List<NewsLetter> getNewsLetterList() {
        return List.of(new NewsLetter(LocalDateTime.now(), NewsLetter.Field.ECONOMY, "Anderson", "Another key inflation measure hit a record high"),
                new NewsLetter(LocalDateTime.now(), NewsLetter.Field.TECHNOLOGY, "Kreig", "The Rising Technology, WEB 3.0"),
                new NewsLetter(LocalDateTime.now(), NewsLetter.Field.POLITICS, "Adams", "Inflation, vaccines, voting rights: Biden faces brick walls"),
                new NewsLetter(LocalDateTime.now(), NewsLetter.Field.SPORTS, "Lopez", "Yeon-koung Kim was selected as the MVP"),
                new NewsLetter(LocalDateTime.now(), NewsLetter.Field.ENTERTAINMENTS, "Winter", "Ariana Grande's New Song released."),
                new NewsLetter(LocalDateTime.now(), NewsLetter.Field.ECONOMY, "Stone", "Bitcoin falling again."),
                new NewsLetter(LocalDateTime.now(), NewsLetter.Field.POLITICS, "Wilbert", "Biden and Democrats run up against relentless conservative power."),
                new NewsLetter(LocalDateTime.now(), NewsLetter.Field.TECHNOLOGY, "Kreig", "Robotics world is comming, CES 2022."),
                new NewsLetter(LocalDateTime.now(), NewsLetter.Field.SPORTS, "Kim", "Menchester United lost to Tottenham"),
                new NewsLetter(LocalDateTime.now(), NewsLetter.Field.ENTERTAINMENTS, "Richard", "Avata 2 crank in!")
        );

    }
}
