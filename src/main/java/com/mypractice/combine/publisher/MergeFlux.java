package com.mypractice.combine.publisher;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class MergeFlux {
    public static void main(String[] args) {
        Flux.merge(Flux.just(1,2,3),Flux.just(1,2,3),Flux.just(1,2,3)).subscribe(Util.subscriber());
     Flux<String> stringFlux =   Flux.merge(QatarFlight.getFlights(), EmirateFlight.getFlights(),
                IndiaFlight.getFlights()  );

     stringFlux.subscribe(Util.subscriber());
     Util.sleepSeconds(10);
    }
}
class QatarFlight{
    public static Flux<String> getFlights(){
     return    Flux.range(1, Util.faker().random().nextInt(1,5))
            .delayElements(Duration.ofSeconds(1))
            .map(i-> "Qatar "+ Util.faker().random().nextInt(100, 999))
            .filter(i-> Util.faker().random().nextBoolean());
    }
}

class EmirateFlight{
    public static Flux<String> getFlights(){
        return   Flux.range(1, Util.faker().random().nextInt(1,10))
                .delayElements(Duration.ofSeconds(1))
                .map(i-> "Emirate "+ Util.faker().random().nextInt(100, 999))
                .filter(i-> Util.faker().random().nextBoolean());
    }
}
class IndiaFlight{
    public static Flux<String> getFlights(){
        return   Flux.range(1, Util.faker().random().nextInt(1,20))
                .delayElements(Duration.ofSeconds(1))
                .map(i-> "India "+ Util.faker().random().nextInt(100, 999))
                .filter(i-> Util.faker().random().nextBoolean());
    }
}