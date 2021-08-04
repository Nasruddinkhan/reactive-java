package com.mypractice.thread;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class ThreadDemo {
    public static void main(String[] args) {
        Flux flux = Flux.create(fluxSink -> {
            printThreadName("create");
            fluxSink.next(1);
           // fluxSink.next(2);

        }).doOnNext(i -> printThreadName("next " + i));
        Runnable runnable = () -> flux.subscribe(v -> printThreadName("sub " + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSeconds(5);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + " ThreadDemo.printThreadName [" + Thread.currentThread().getName() + "]");
    }
}
