package com.mypractice.flux;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

public class MonoToFlux {
    public static void main(String[] args) {
     Mono<Tuple2<A, B>> tuple2Mono =   Mono.zip(Mono.just(new A()), Mono.just(new B()));
        tuple2Mono.ofType(A.class).subscribe(Util.subscriber());
        tuple2Mono.ofType(B.class).subscribe(Util.subscriber());
        Flux.range(1,10)
                .filter(no -> no>3)
                .next()
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        Flux<Tuple2<Long, Integer>> source = Flux.just(1, 2, 3)
                .delayElements(Duration.ofMillis(1000))
                .replay(2, Duration.ofMillis(2000))
                .hide()
                .autoConnect()
                .hide()
                .elapsed();

        source.subscribe(Util.subscriber());
        Util.sleepSeconds(50);
    }
}
class  A{

}
class B{

}