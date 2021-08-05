package com.mypractice.buffer;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookRevenueState {
    public static void main(String[] args) {

        Set<String> allowCategory = Set.of("Science fiction", "Fantasy", "Suspense/Thriller");

        bookStream().filter(bookOrder -> allowCategory.contains(bookOrder.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(l -> revenueReport(l))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    public static RevenueReport revenueReport(List<BookOrder> books) {
        Map<String, Double> stringDoubleMap
                = books.stream().collect(Collectors.groupingBy(BookOrder::getCategory,
                Collectors.summingDouble(BookOrder::getPrice)));
        return new RevenueReport(stringDoubleMap);
    }

    private static Flux<BookOrder> bookStream() {
        return Flux.interval(Duration.ofMillis(200)).map(b -> new BookOrder());
    }
}
