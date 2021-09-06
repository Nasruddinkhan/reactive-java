package com.mypractice.hot.cold.publisher;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class HotPublisherChache {
    public static void main(String[] args) {
        // replay the first publisher
        Flux<String> stringFluxMoview = Flux.fromStream(()-> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .cache();
        Util.sleepSeconds(2);

        stringFluxMoview.subscribe(Util.subscriber("Nasruddin"));
        Util.sleepSeconds(3);
        System.out.println("HotPublisherAutoConnect.main jalaluddin join");
        stringFluxMoview.subscribe(Util.subscriber("Jalaluddin"));
        Util.sleepSeconds(10);

    }
    public static Stream<String> getMovie(){
        System.out.println("got the HotPublisher.getMovie");
        return Stream.of("Scene1", "Scene2", "Scene3", "Scene4", "Scene5", "Scene6", "Scene7", "Scene8", "Scene9");
    }
}
