package com.mypractice.operator;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OnErrorPipeline {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                 .onErrorReturn(-1)
                //.onErrorResume(s -> fallBack(s)) //microservice
                 //.onErrorReturn(-1)
                //.onErrorResume(s -> fallBack()) //microservice
                 .onErrorContinue((err, obj)-> {
                     System.out.println("OnErrorPipeline.main ["+obj+"]");
                     System.out.println("OnErrorPipeline.main err ["+err.getMessage()+"]");
                     return;
                 })
                .subscribe(Util.subscriber());
    }

    public static Mono<Integer> fallBack(Throwable throwable) {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}
