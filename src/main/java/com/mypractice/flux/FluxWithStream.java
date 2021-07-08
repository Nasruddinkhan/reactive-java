package com.mypractice.flux;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxWithStream {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        Stream<Integer> integerStream = integers.stream();

        Flux<Integer>   integerFlux = Flux.fromStream(integerStream);
        Flux<Integer>   supplierFlux = Flux.fromStream(()-> integers.stream());

        integerFlux.subscribe(Util.onNext(), Util.onNext(), Util.onComplete());
        supplierFlux.subscribe(Util.onNext(), Util.onNext(), Util.onComplete());

    }
}
