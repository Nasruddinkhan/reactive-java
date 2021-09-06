package com.mypractice.program;

import com.mypractice.util.Util;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxSequenceFlow {
    public static void main(String[] args) {
        //Sequence Flow
        Flux.range(1, 10)
                .map(i -> i + 1)
                .map(i -> i * 2)
                .map(i -> i + 1)
                .subscribe(System.out::println);
        Util.sleepSeconds(2);

        System.out.println("FluxSequenceFlow.main paraller");
        //parller
        Flux.range(1, 10)
                .parallel(2)
                .runOn(Schedulers.parallel())
                .map(i -> i + 1)
                .map(i -> i * 2)
                .map(i -> i + 1)
                .subscribe(System.out::println);
        Util.sleepSeconds(2);

        System.out.println("FluxSequenceFlow.main Group");
        //parller
        Flux.range(1, 30)
                .parallel(10)
                .runOn(Schedulers.parallel())
                .groups()
                .map(gf -> new ItemGroup(gf.key(), gf))
                .subscribe(System.out::println);
        Util.sleepSeconds(2);

        System.out.println("FluxSequenceFlow.main subscribe Group");
        //parller
        Flux.range(1, 30)
                .parallel(4)
                .runOn(Schedulers.parallel())
                .groups()
                .map(gf -> new ItemGroup(gf.key(), gf))
                .flatMap(g-> g.getItems().collectList())
                .subscribe(System.out::println);
        Util.sleepSeconds(2);
        System.out.println("FluxSequenceFlow.main subscribe parraller sequecnce Group");

        Flux.range(1, 10)
                .parallel(5)
                .runOn(Schedulers.parallel())
                .map(i -> i * 2)
                .sequential()
                .publishOn(Schedulers.single())
                .map(i -> i + 2)
                .subscribe(System.out::println);
        Util.sleepSeconds(2);

    }
}
@Data
@AllArgsConstructor
@ToString
 class ItemGroup {

    private int threadIndex;
    private Flux<Integer> items;

}