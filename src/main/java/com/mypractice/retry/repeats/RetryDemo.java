package com.mypractice.retry.repeats;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        getIntegers()
                .retry(2)
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getIntegers() {
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscriber"))
                .doOnComplete(() -> System.out.println("---Complete"))
                .map(i ->i / (Util.faker().random().nextInt(1, 5) > 3 ? 0 : 1))
                .doOnEach(err -> System.out.println("--error"));

    }
}
