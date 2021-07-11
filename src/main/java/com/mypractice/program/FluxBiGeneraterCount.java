package com.mypractice.program;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FluxBiGeneraterCount {
    public static void main(String[] args) {
        Flux.generate(() -> 1, (counter, sink) -> {
            String name = Util.faker().artist().name();
            sink.next(name);
            if (counter >= 20 )
                sink.complete();
            System.out.println("FluxGenerate.main [" + name + "] count [" + counter + "]");

            return counter + 1;
        }).take(4).subscribe(Util.subscriber());
    }
}
