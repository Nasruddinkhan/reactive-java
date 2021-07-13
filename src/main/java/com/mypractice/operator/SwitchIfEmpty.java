package com.mypractice.operator;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumber().filter(integer -> integer > 10)
                .log()
                .switchIfEmpty(fallBack()) //it's like error
                .subscribe(Util.subscriber());
    }
    //redis & hazelcast
    private static Flux<Integer> getOrderNumber() {
        return Flux.range(1, 10);
    }
    //db
    private static Flux<Integer> fallBack() {
        return Flux.range(20, 5);
    }
}
