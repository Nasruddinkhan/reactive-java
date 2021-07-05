package com.mypractice.mono;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        //   getName().subscribe(Util.onNext()); // blocking
        // getName().subscribeOn(Schedulers.boundedElastic()).subscribe(Util.onNext()); // non blocking
        String name = getName().subscribeOn(Schedulers.boundedElastic()).block();
        System.out.println(name);
        getName();
        Util.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("SupplierRefactoring.getName");
        return Mono.fromSupplier(() -> {
            System.out.println("generating name... ");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
