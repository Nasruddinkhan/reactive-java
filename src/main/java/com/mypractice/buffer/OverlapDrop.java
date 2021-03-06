package com.mypractice.buffer;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class OverlapDrop {
    public static void main(String[] args) {
        eventStream()
                .buffer(3, 5) //overlapping and dropping
                // .buffer(Duration.ofSeconds(2))
                //.bufferTimeo ut(5, Duration.ofSeconds(2))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(800))
                // .take(3)
                .map(i -> "even"+i);
    }
}
