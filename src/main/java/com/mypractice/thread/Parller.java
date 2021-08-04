package com.mypractice.thread;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Parller {
    public static void main(String[] args) {
        Flux.range(1,10)
                .parallel(10)
                .runOn(Schedulers.boundedElastic())
                .doOnNext(integer -> printThread("next\t"+integer))
                .sequential() //convert single
                .subscribe(v-> printThread("suscribe\t"+v));
        Util.sleepSeconds(5);
    }

    private static void printThread(String s) {
        System.out.println(s+" \t"+Thread.currentThread().getName());
    }
}
