package com.mypractice.combine.publisher;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class ContcatFlux {
    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d", "e", "f");
        Flux<String> fluxError= Flux.error(new RuntimeException("some error"));
    //  Flux<String> flux =  flux1.concatWith(flux2);
        //Flux<String> flux =  Flux.concat(flux1, flux2);

        Flux<String> flux =  Flux.concat(flux1, flux2);
        Flux<String> fluxd =  Flux.concatDelayError(flux1,fluxError, flux2);

        flux.subscribe(Util.subscriber());
        fluxd.subscribe(Util.subscriber());
    }
}
