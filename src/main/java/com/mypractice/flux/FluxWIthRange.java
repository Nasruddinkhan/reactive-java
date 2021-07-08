package com.mypractice.flux;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FluxWIthRange {
    public static void main(String[] args) {
        Flux.range(5,20)
                .map(i-> Util.faker().name().fullName())
                .subscribe(Util.onNext());
    }
}
