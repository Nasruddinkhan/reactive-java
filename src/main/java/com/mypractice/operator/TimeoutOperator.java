package com.mypractice.operator;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class TimeoutOperator {
    public static void main(String[] args) {
        getOrderNumber()
                .timeout(Duration.ofSeconds(2), fallBack())

                .subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }

    private static Flux<Integer> getOrderNumber() {
        // return Flux.range(1, 10).delayElements(Duration.ofSeconds(5));
        return Flux.range(1, 10).delayElements(Duration.ofSeconds(1));

    }

    private static Flux<Integer> fallBack() {
        return Flux.range(100, 10).delayElements(Duration.ofMillis(200));
    }
}
