package com.mypractice.operator;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class DefaultEmpty {
    public static void main(String[] args) {
        getOrderNumber().filter(integer -> integer > 10)
                .log()
                .defaultIfEmpty(-100) //it's like error
                .subscribe(Util.subscriber());

    }

    private static Flux<Integer> getOrderNumber() {
        return Flux.range(1, 12);
    }
}
