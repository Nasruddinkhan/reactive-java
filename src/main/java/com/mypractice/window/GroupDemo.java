package com.mypractice.window;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class GroupDemo {

    public static void main(String[] args) {
        Flux.range(1, 30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(b -> b % 2)
                .subscribe(gf -> process(gf, gf.key()));
        Util.sleepSeconds(60);
    }

    public static void process(Flux<Integer> flux, int key) {
        System.out.println("Called");
        flux.subscribe(i -> System.out.println("key = " + key + " value = " + i));
    }

}
