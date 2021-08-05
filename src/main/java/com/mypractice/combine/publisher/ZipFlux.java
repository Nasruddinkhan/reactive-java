package com.mypractice.combine.publisher;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class ZipFlux {
    public static void main(String[] args) {
        Flux.zip(getBody(), getEngine(), getTires())
                //.doOnNext(tuple-> tuple.toArray())
                .subscribe(Util.subscriber());
    }

    public static Flux<String> getBody(){
        return Flux.range(1, 15)
                .map(i->"body "+i);
    }

    public static Flux<String> getEngine(){
        return Flux.range(1, 10)
                .map(i->"Engine "+i);
    }

    public static Flux<String> getTires(){
        return Flux.range(1, 15)
                .map(i->"Tires "+i);
    }
}
