package com.mypractice.overflow;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class OverflowBackPresserError {
    public static void main(String[] args) {
        System.setProperty("reactor.bufferSize.small", "16");// emit 75% of data after change the value
        Flux.create(fluxSink -> {
            for (int i = 1; i <201 &&  !fluxSink.isCancelled(); i++) {
                fluxSink.next(i);
                System.out.println("paused : = " + i);
                Util.sleepMilliSeconds(1);
            }
            fluxSink.complete();
        })
                //.onBackpressureBuffer()
                .onBackpressureError()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMilliSeconds(10);
                }).subscribe(Util.subscriber());
        Util.sleepSeconds(10);
    }
}
