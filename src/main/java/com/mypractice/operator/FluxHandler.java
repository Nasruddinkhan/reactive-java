package com.mypractice.operator;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FluxHandler {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String name = Util.faker().animal().name();
            synchronousSink.next(name);
        }).map(Object::toString).handle((o, synchronousSink) -> {
            System.out.println("FluxHandler.main [" + o + "]");
            synchronousSink.complete();

            if (o.equals("cat")) {
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());
    }
}
