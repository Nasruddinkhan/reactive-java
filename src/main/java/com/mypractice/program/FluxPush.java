package com.mypractice.program;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FluxPush {
    public static void main(String[] args) {
        var animalProducer = new AnimalProducer();
        Flux.push(animalProducer).subscribe(Util.subscriber());

        Runnable runnable = animalProducer::produce;
        for (var i = 1; i <= 10; i++) {
            new Thread(runnable).start();
        }
    }
}
