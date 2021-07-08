package com.mypractice.flux;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxWIthList {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        String[] stringArray = {"a","b","c","d"};
        Flux.fromIterable(integers).subscribe(Util.onNext());
        Flux.fromArray(stringArray).subscribe(Util.onNext());

    }
}
