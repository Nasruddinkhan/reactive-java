package com.mypractice.sinks;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class SinkReplay {
    public static void main(String[] args) {

        //We handle the push item
        Sinks.Many<Object> sinks = Sinks.many().replay().all();
        //handle throught which sub recived item
        Flux<Object> flux = sinks.asFlux();
        sinks.tryEmitNext("HI");
        sinks.tryEmitNext("How r u ");
        //for (int i = 0; i < 1000; i++) {
        flux.subscribe(Util.subscriber("Nasruddin"));
        flux.subscribe(Util.subscriber("Jalaluddin"));
        // }

        //for (int i = 0; i < 100; i++) {
            sinks.tryEmitNext("?");
        flux.subscribe(Util.subscriber("Jalaluddin 1"));

        // }
        sinks.tryEmitNext("new message");

    }
}
