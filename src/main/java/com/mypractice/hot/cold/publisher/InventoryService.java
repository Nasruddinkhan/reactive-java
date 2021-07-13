package com.mypractice.hot.cold.publisher;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class InventoryService {


    private Map<String, Integer> stringDoubleMap = new HashMap<>();

    public InventoryService() {
        this.stringDoubleMap.put("Books", 100);
        this.stringDoubleMap.put("Home & Tools", 100);

    }

    public Consumer<PurchaseOrder> subscribeOrderStream() {
        return p -> stringDoubleMap.computeIfPresent(p.getCategory(), (k, v) -> v - p.getQty());
    }

    public Flux<String> inventoryStream() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> stringDoubleMap.toString());
    }
}
