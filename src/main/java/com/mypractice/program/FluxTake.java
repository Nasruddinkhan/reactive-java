package com.mypractice.program;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FluxTake {
    public static void main(String[] args) {
        Flux.range(1, 10).log().take(5).log().subscribe(Util.onNext());
    }
}
