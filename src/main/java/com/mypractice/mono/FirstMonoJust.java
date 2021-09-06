package com.mypractice.mono;

import reactor.core.publisher.Mono;

public class FirstMonoJust {
    public static void main(String[] args) {
        Mono<Integer> integerMono = Mono.just(1); //called publi
        System.out.println(integerMono);
        integerMono.subscribe(integer -> System.out.println("\n Received " + integer));
        integerMono.subscribe(integer -> System.out.println("\n Received " + integer));
        integerMono.subscribe(integer -> System.out.println("\n Received " + integer));
        integerMono.subscribe(integer -> System.out.println("\n Received " + integer));

    }
}
