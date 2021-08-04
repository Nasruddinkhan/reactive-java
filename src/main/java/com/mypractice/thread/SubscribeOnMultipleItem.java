package com.mypractice.thread;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class SubscribeOnMultipleItem {
    public static void main(String[] args) {
        Flux flux = Flux.create(fluxSink -> {
            printThreadName("create");
            for (int i = 0; i < 4; i++) {
                fluxSink.next(i);
                Util.sleepSeconds(1);
            }
            fluxSink.complete();

        })
                .doOnNext(i -> printThreadName("next " + i));

     // Runnable runnable =()->
              flux
                .subscribeOn(Schedulers.boundedElastic())
                //.subscribeOn(Schedulers.parallel())  //CPU task not like paraller

                .subscribe(s -> printThreadName("sub" + s));

        flux
                .subscribeOn(Schedulers.parallel())
                //.subscribeOn(Schedulers.parallel())  //CPU task not like paraller

                .subscribe(s -> printThreadName("parallel" + s));
      //  for (int i = 0; i < 5; i++) {
       //     new Thread(runnable).start();
       // }
        Util.sleepSeconds(5);
    }


    private static void printThreadName(String msg) {
        System.out.println(msg + " ThreadDemo.printThreadName [" + Thread.currentThread().getName() + "]");
    }
}
