package com.mypractice.operator;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class LimitRate {
    public static void main(String[] args) {
        Flux.range(2,2000).log()
               // .limitRate(200)
                .limitRate(100, 99)
                .subscribe(Util.subscriber());
    }

}
