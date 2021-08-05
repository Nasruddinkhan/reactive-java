package com.mypractice.window;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class WindowDemo {
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        eventStream()
                // .window(5)
                .window(Duration.ofSeconds(5))
                .flatMap(flux -> saveEvent(flux))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }

    public static Mono<Integer> saveEvent(Flux<String> flux) {
        return flux.doOnNext(e -> System.out.println("saving " + e)).doOnComplete(() -> {
            System.out.println("save this batch");
            System.out.println("-----------");
        }).then(Mono.just(atomicInteger.getAndIncrement()));
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(800))
                // .take(3)
                .map(i -> "even" + i);
    }
}
