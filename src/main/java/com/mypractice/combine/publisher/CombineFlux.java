package com.mypractice.combine.publisher;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class CombineFlux {
    public static void main(String[] args) {
        Flux.combineLatest(getString(), getNumber() , (s, n)-> s + n)
            .subscribe(Util.subscriber());
        Util.sleepSeconds(10);
    }

    public static Flux<String> getString() {
        return Flux.just("A", "B", "C", "D", "E").delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> getNumber() {
        return Flux.just(1, 2, 3, 4, 5).delayElements(Duration.ofSeconds(1));
    }


}
