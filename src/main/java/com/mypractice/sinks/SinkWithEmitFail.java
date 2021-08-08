package com.mypractice.sinks;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkWithEmitFail {
    public static void main(String[] args) {
        Sinks.One<Object> objectOne = Sinks.one();
        Mono<Object> objectMono = objectOne.asMono();
        objectMono.subscribe(Util.subscriber("Nasruddin  khan"));
        objectOne.emitValue("HI", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());

            return false;
        }));

        objectOne.emitValue("Hello", ((signalType, emitResult) -> {
            System.out.println(signalType.name());
            System.out.println(emitResult.name());

            return false;
        }));
    }
}
