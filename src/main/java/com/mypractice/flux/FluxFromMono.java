package com.mypractice.flux;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxFromMono {
    public static void main(String[] args) {
        Mono<String> stringMono = Mono.just("Nasruddin");
        Flux<String> stringFlux = Flux.from(stringMono).log();
        stringFlux.subscribe(Util.onNext());
     }


}
