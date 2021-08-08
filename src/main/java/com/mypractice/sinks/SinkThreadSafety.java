package com.mypractice.sinks;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SinkThreadSafety {
    public static void main(String[] args) {
        //We handle the push item
        Sinks.Many<Object> sinks = Sinks.many().unicast().onBackpressureBuffer();
        //handle throught which sub recived item
        Flux<Object> flux = sinks.asFlux();
        List<Object> objects = new ArrayList<>();
        flux.subscribe(objects::add);
       /* for (var i = 0; i < 1000; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> sinks.tryEmitNext(finalI));
        }*/
        for (var i = 0; i < 1000; i++) {
            int finalI = i;
            CompletableFuture.runAsync(() -> sinks.emitNext(finalI, (s, e) -> true));
        }
        Util.sleepSeconds(3);
        System.out.println(objects.size());


    }
}
