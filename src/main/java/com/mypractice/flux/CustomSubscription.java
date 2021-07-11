package com.mypractice.flux;

import com.mypractice.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class CustomSubscription {
    public static void main(String[] args) {
        AtomicReference<Subscription> subscriptionAtomicReference = new AtomicReference<>();
        Flux.range(0,20).log().subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("CustomSubscription.onSubscribe");
                System.out.println("Received.onSubscribe ["+s+"]");
                subscriptionAtomicReference.set(s);

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("CustomSubscription.onNext ["+integer+"]");
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("CustomSubscription.onError ["+t.getMessage()+"]");
            }

            @Override
            public void onComplete() {
                System.out.println("CustomSubscription.onComplete");
            }
        });
        Util.sleepSeconds(5);
        subscriptionAtomicReference.get().request(3);
        Util.sleepSeconds(5);
        subscriptionAtomicReference.get().request(5);
        System.out.println("CustomSubscription.main calling cancel");
        subscriptionAtomicReference.get().cancel();
        System.out.println("CustomSubscription.main done calling cancel");

        Util.sleepSeconds(5);
        subscriptionAtomicReference.get().request(3);
        System.out.println("CustomSubscription.main complete");

    }

}