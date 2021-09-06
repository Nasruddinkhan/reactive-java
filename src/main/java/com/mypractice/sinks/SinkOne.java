package com.mypractice.sinks;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkOne {
    public static void main(String[] args) {
        Sinks.One<Object> objectOne = Sinks.one();
        Mono<Object> objectMono = objectOne.asMono();
        objectOne.tryEmitValue("Hi ");
        objectMono.subscribe(Util.subscriber("Nasruddin  khan"));
        objectMono.subscribe(Util.subscriber("Jalauddin khan"));
    }
}
