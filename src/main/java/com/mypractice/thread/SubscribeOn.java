package com.mypractice.thread;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SubscribeOn {
    public static void main(String[] args) {
        Flux flux = Flux.create(fluxSink -> {
            printThreadName("create");
            fluxSink.next(1);
            // fluxSink.next(2);

        })
                //.subscribeOn(Schedulers.newParallel("nkhan"))
                .doOnNext(i -> printThreadName("next " + i));

       Runnable runnable = ()-> flux.doFirst(() -> System.out.println("SubscribeOn.main  Second one"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> System.out.println("SubscribeOn.main First one"))
                .subscribe(s -> printThreadName("sub" + s));
        for (int i = 0; i <2 ; i++) {
            new Thread(runnable).start();
        } 
       Util.sleepSeconds(5);
    }


    private static void printThreadName(String msg) {
        System.out.println(msg + " ThreadDemo.printThreadName [" + Thread.currentThread().getName() + "]");
    }
}
