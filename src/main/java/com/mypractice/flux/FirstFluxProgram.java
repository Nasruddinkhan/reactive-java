package com.mypractice.flux;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FirstFluxProgram {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5);
       // Flux<Integer> integerFlux = Flux.empty(); //only complete
        integerFlux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Flux<Object> fluxObjec = Flux.just(1, 2, 3, 4, 5, "ABC", Util.faker().name().fullName());
        // Flux<Integer> integerFlux = Flux.empty(); //only complete
        fluxObjec.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
