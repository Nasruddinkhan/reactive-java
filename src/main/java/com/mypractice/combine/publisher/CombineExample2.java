package com.mypractice.combine.publisher;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class CombineExample2 {
    public static void main(String[] args) {
        final int initialPrice = 10000;
        Flux.combineLatest(monthStream(), demandStream(), (month, demand) -> {
            System.out.println(month + " " + demand);
            return (initialPrice - (month * 100) * demand);
        })
                //.take(12)
                .subscribe(Util.subscriber());
        Util.sleepSeconds(20);
    }

    private static Flux<Long> demandStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }


    private static Flux<Double> monthStream() {
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(3))
                .map(i -> Util.faker().random().nextInt(80, 120) / 100d);

    }
}
