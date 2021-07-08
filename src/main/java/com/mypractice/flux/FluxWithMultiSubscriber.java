package com.mypractice.flux;

import reactor.core.publisher.Flux;

public class FluxWithMultiSubscriber {

    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5);
        Flux<Integer> eventFlux = integerFlux.filter(i-> i%2 ==0);
        integerFlux.subscribe(i -> System.out.println("subscriber 1 " +i));
        eventFlux.subscribe(i -> System.out.println("eventFlux subscriber " +i));

    }


}
