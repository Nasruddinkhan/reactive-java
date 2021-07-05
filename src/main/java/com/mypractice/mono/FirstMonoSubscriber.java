package com.mypractice.mono;

import reactor.core.publisher.Mono;

public class FirstMonoSubscriber {
    public static void main(String[] args) {
        Mono<String> stringMono = Mono.just("Nasruddin khan");
        stringMono.subscribe(
                s -> System.out.println(s),
                throwable -> System.out.println(throwable.getMessage()),
                ()-> System.out.println("Complete")
        );


        Mono<Integer> errorMono = Mono.just("Nasruddin khan").map(String::length).map(l-> l/0);
        errorMono.subscribe(
                s -> System.out.println(s),
                throwable -> System.out.println(throwable.getMessage()),
                ()-> System.out.println("Complete")
        );
    }
}
