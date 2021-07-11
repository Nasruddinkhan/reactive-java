package com.mypractice.program;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class RefactorFluxCreate {
    public static void main(String[] args) {
        var animalProducer = new AnimalProducer();
        Flux.create(animalProducer).subscribe(Util.subscriber());
        Runnable runnable = animalProducer::produce;
        for (var i = 0; i <10 ; i++) {
            new Thread(runnable).start();
        }
       // Util.sleepSeconds(2);
    }
}
