package com.mypractice.mono;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;

public class SecMonoProgram {

    public static void main(String[] args) {
        Mono<String> stringMono = Mono.just("Nasruddin khan");
        stringMono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
