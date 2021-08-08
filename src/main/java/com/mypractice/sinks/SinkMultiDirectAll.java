package com.mypractice.sinks;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class SinkMultiDirectAll {
    public static void main(String[] args) {
        System.getProperty("reactor.bufferSize.small", "16");

        //We handle the push item
        Sinks.Many<Object> sinks = Sinks.many().multicast().directBestEffort();
        //handle throught which sub recived item
        Flux<Object> flux = sinks.asFlux();
        sinks.tryEmitNext("HI");
        sinks.tryEmitNext("How r u ");
        //for (int i = 0; i < 1000; i++) {
        flux.subscribe(Util.subscriber("Nasruddin"));
        flux.delayElements(Duration.ofMillis(2)).subscribe(Util.subscriber("Jalaluddin"));
        // }

        for (int i = 0; i < 100; i++) {
            sinks.tryEmitNext(i);
        }
        Util.sleepSeconds(10);
    }
}
