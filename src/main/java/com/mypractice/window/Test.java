package com.mypractice.window;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {

        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>>
                map = Map.of("Kids", OrderProcessor.processing2(),
                "Automotive", OrderProcessor.processing2());

        Set<String> set = map.keySet();
        OrderService.orderStream().filter(p -> set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory)
                .flatMap(gf -> map.get(gf.key()).apply(gf))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

}
