package com.mypractice.window;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class OrderProcessor {
    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> processing() {
        return flux -> flux.doOnNext(p -> p.setPrice(1.1 * p.getPrice()))
                .doOnNext(p -> p.setItem("[ " + p.getItem() + " ]"));
    }

    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> processing2() {
        return flux -> flux.doOnNext(p -> p.setPrice(0.5 * p.getPrice()))
                .flatMap(p -> Flux.concat(freeOrder(), Mono.just(p)));
    }

    public static Mono<PurchaseOrder> freeOrder() {
        return Mono.fromSupplier(() -> {
            PurchaseOrder purchaseOrder = new PurchaseOrder();
            purchaseOrder.setItem("Free " + purchaseOrder.getItem());
            purchaseOrder.setPrice(0.0);
            purchaseOrder.setCategory("kids");
            return purchaseOrder;
        });

    }
}
