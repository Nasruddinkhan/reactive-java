package com.mypractice.flux;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxWithInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1)).log().subscribe(Util.onNext());
        Util.sleepSeconds(5);
    }
}
