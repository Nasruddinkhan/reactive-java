package com.mypractice.hot.cold.publisher;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class ColdPublisher {
    public static void main(String[] args) {
       Flux<String>  stringFluxMoview = Flux.fromStream(()-> getMovie())
        .delayElements(Duration.ofSeconds(2));
        stringFluxMoview.subscribe(Util.subscriber("Nasruddin"));
        Util.sleepSeconds(5);
        stringFluxMoview.subscribe(Util.subscriber("Jalaluddin"));
        Util.sleepSeconds(60);

    }
    public static Stream<String> getMovie(){
        System.out.println("got the ColdPublisher.getMovie");
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6", "Scene7", "Scene8", "Scene9");
    }
}
