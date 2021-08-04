package com.mypractice.thread;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class PublishOnWithSubsription {
    public static void main(String[] args) {
        Flux flux = Flux.create(fluxSink -> {   //produce the data
            printThreadName("create");
            for (int i = 0; i < 4; i++) {
                fluxSink.next(i);
                Util.sleepSeconds(1);
            }
            fluxSink.complete();

        }).doOnNext(i -> printThreadName("next " + i));

        flux.publishOn(Schedulers.parallel())               //consume the data
                .doOnNext(i -> printThreadName("next " + i))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(s -> printThreadName("sub" + s));

        Util.sleepSeconds(5);
    }


    private static void printThreadName(String msg) {
        System.out.println(msg + " PublishOnWithSubsription.printThreadName [" + Thread.currentThread().getName() + "]");
    }
}
