package com.mypractice.program;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            fluxSink.next(1);
            fluxSink.next(2);
            fluxSink.complete();
        }).subscribe(Util.subscriber());

        Flux.range(0,20).subscribe(Util.subscriber());

        Flux.create(fluxSink -> {
            String name;
            do{
                name= Util.faker().animal().name();
                fluxSink.next(name);

            }while ( !name.equalsIgnoreCase("cat"));
        }).subscribe(Util.subscriber());


    }
}
