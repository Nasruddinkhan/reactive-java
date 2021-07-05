package com.mypractice.mono;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class MonoSuplier {
    public static void main(String[] args) {
        // Mono<String> stringMono = Mono.just(getName());
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> supplierMono = Mono.fromSupplier(stringSupplier);
        supplierMono.subscribe(Util.onNext());
        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable).subscribe(Util.onNext());
    }

    private static String getName() {
        System.out.println("generating name... ");
        return Util.faker().name().fullName();
    }
}
