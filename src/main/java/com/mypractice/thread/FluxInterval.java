package com.mypractice.thread;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.subscriber()); //interal use scheduller parller thread
        Util.sleepSeconds(60);
    }
}
