package com.mypractice.sinks;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinkMultiCast {
    public static void main(String[] args) {
        //We handle the push item
        Sinks.Many<Object> sinks = Sinks.many().multicast().onBackpressureBuffer();
        //handle throught which sub recived item
        Flux<Object> flux = sinks.asFlux();
        for (int i = 0; i < 1000; i++) {
            flux.subscribe(Util.subscriber("Nasruddin" + i));

        }
        // flux.subscribe(Util.subscriber("Jalaluddin khan"));

        sinks.tryEmitNext("HI");
        sinks.tryEmitNext("How r u ");
        sinks.tryEmitNext("?");


    }
}
