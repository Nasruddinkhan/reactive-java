package com.mypractice.retry.repeats;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class RepeatWitConditionDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        getIntegers()
                .repeat(() -> atomicInteger.get() < 20)
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getIntegers() {
        return Flux.range(1, 5)
                .doOnSubscribe(s -> System.out.println("Subscriber"))
                .doOnComplete(() -> System.out.println("---Complete"))
                .map(i -> atomicInteger.getAndIncrement());

    }
}
