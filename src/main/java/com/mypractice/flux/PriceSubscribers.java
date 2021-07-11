package com.mypractice.flux;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class PriceSubscribers {
    public static void main(String[] args) throws InterruptedException {
      var countDownLatch =  new CountDownLatch(1);
        PricePublisher.getPrice().log().subscribeWith(new Subscriber<Integer>() {
            private  Subscription s;
            @Override
            public void onSubscribe(Subscription s) {
                this.s = s;
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer price) {
                System.out.println("PriceSubscriber.onNext ["+ LocalDateTime.now()+"] price ["+price+"]");
                if(price<=85 || price > 150){
                    countDownLatch.countDown();
                    s.cancel();
                }
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("PriceSubscriber.onError ["+t.getMessage()+"]");
                countDownLatch.countDown();
            }

            @Override
            public void onComplete() {
                System.out.println("PriceSubscriber.onComplete");
                countDownLatch.countDown();

            }
        });
        countDownLatch.await();
    }
}
