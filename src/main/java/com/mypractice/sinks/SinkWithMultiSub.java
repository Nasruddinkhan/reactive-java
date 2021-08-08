package com.mypractice.sinks;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkWithMultiSub {
    public static void main(String[] args) {
        Sinks.One<Object> objectOne = Sinks.one();
        Mono<Object> objectMono = objectOne.asMono();
        objectMono.subscribe(Util.subscriber("Nasruddin  khan"));
        objectMono.subscribe(Util.subscriber("Jalaludin  khan"));

        objectOne.tryEmitValue("HI ");
    }
}
