package com.mypractice.thread;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Parllel {
    public static void main(String[] args) {
       List<Integer> integers = new ArrayList<>();
        Flux.range(1,1000)
                .parallel()
                .runOn(Schedulers.parallel())
                //.doOnNext(integer -> printThread("next\t"+integer))
                //.subscribe(v-> printThread("suscribe\t"+v));
                .subscribe(v-> integers.add(v));
       // Util.sleepSeconds(integers.size());
        Util.sleepSeconds(5);
        Util.sleepSeconds(integers.size());

    }

    private static void printThread(String s) {
        System.out.println(s+" \t"+Thread.currentThread().getName());
    }
}
