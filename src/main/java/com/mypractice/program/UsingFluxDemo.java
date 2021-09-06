package com.mypractice.program;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsingFluxDemo {
    public static void main(String[] args) throws InterruptedException {
        // resource
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));

// creating a flux with resources
        Flux<Integer> flux = Flux.using(
                () -> list,
                (l) -> Flux.fromIterable(l),
                (l) -> l.clear()
        );
        System.out.println("Before : " + list.size());

// consume the resource
        flux.subscribe(System.out::println);

// just wait for resource consumption
        Thread.sleep(3000);

// print the size of the resource
        System.out.println("After : " + list.size());

    }
}
