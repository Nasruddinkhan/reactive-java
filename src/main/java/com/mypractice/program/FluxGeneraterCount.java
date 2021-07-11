package com.mypractice.program;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class FluxGeneraterCount {
    public static void main(String[] args) {
        // max 20
        var atomicInteger = new AtomicInteger();
        Flux.generate(synchronousSink -> {
            var count = atomicInteger.incrementAndGet();

            String name = Util.faker().artist().name();
            System.out.println("FluxGenerate.main [" + name + "] count ["+count+"]");
            synchronousSink.next(name);
            if (count == 20) {
                System.out.println("FluxGeneraterCount.main complete");
                synchronousSink.complete();
            }
            // synchronousSink.next(2);
            // synchronousSink.next(3);

        }).subscribe(Util.subscriber());
    }

}
