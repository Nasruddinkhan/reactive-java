package com.mypractice.flux;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class MonoToFlux {
    public static void main(String[] args) {
        Flux.range(1,10)
                .filter(no -> no>3)
                .next()
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
