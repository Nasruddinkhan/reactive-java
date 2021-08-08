package com.mypractice.sinks;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkUniCast {
    public static void main(String[] args) {
        //We handle the push item
        Sinks.Many<Object> sinks = Sinks.many().unicast().onBackpressureBuffer();
        //handle throught which sub recived item
        Flux<Object> flux = sinks.asFlux();
        flux.subscribe(Util.subscriber("Nasruddin"));

        sinks.tryEmitNext("HI");
        sinks.tryEmitNext("How r u ");
        sinks.tryEmitNext("?");


    }
}
