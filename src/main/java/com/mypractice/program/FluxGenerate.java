package com.mypractice.program;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FluxGenerate {
    public static void main(String[] args) {
        //allow only one item
        Flux.generate(synchronousSink -> {
            String name =  Util.faker().artist().name();
            System.out.println("FluxGenerate.main ["+name+"]");
            synchronousSink.next(name);
           // synchronousSink.complete();
           // synchronousSink.next(2);
           // synchronousSink.next(3);

        }).take(2).subscribe(Util.subscriber());
    }
}
