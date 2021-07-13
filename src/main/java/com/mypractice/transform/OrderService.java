package com.mypractice.transform;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private static Map<Integer, List<PurchaseOrder>> purchaseOrder = new HashMap<>();

    static {
        purchaseOrder.put(1, List.of(
                new PurchaseOrder(1),
                new PurchaseOrder(1),
                new PurchaseOrder(1)));
        purchaseOrder.put(2, List.of(
                new PurchaseOrder(2),

                new PurchaseOrder(2)));
        purchaseOrder.put(3, List.of(
                new PurchaseOrder(3),

                new PurchaseOrder(3)));
    }

    public static Flux<PurchaseOrder> getOrderFlux(int userId) {
        return Flux.create((FluxSink<PurchaseOrder> purchaseOrderFluxSink) -> {
            purchaseOrder.get(userId).forEach(purchaseOrderFluxSink::next);
            purchaseOrderFluxSink.complete();
        })
                .delayElements(Duration.ofSeconds(1));
    }
}
