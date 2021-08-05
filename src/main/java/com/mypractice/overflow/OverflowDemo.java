package com.mypractice.overflow;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class OverflowDemo {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("paused : = " + i);
            }
            fluxSink.complete();
        }).publishOn(Schedulers.boundedElastic())
        .doOnNext(i->{
            Util.sleepMilliSeconds(10);
        }).subscribe(Util.subscriber());
    //Util.sleepSeconds(60);
    }
}
