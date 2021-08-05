package com.mypractice.buffer;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class BufferDemo {
    public static void main(String[] args) {
        eventStream()
                //.buffer(5)
               // .buffer(Duration.ofSeconds(2))
                .bufferTimeout(5, Duration.ofSeconds(2))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(800))
               // .take(3)
                .map(i -> "even"+i);
    }
}
