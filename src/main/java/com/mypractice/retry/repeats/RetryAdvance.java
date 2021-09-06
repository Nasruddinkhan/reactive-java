package com.mypractice.retry.repeats;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

public class RetryAdvance {

    public static void main(String[] args) {
        getOrder(Util.faker().business().creditCardNumber())
                .doOnError(err -> System.out.println(err.getMessage()))
                 .retry(5)
                .retryWhen(Retry.from(
                        flux -> flux.doOnNext(retrySignal -> {
                            System.out.println(retrySignal.totalRetries());
                            System.out.println(retrySignal.failure());
                        }).handle((retrySignal, synchronousSink) -> {
                            if (retrySignal.failure().getMessage().equals("500"))
                                synchronousSink.next(1);
                            else
                                synchronousSink.error(retrySignal.failure());
                        }).delayElements(Duration.ofSeconds(1))
                ))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }


    public static Mono<String> getOrder(String ccNumber) {
        return Mono.fromSupplier(() -> {
            processPayment(ccNumber);
            return Util.faker().idNumber().valid();
        });

    }

    public static void processPayment(String ccNumber) {
        int random = Util.faker().random().nextInt(1, 10);
        if (random < 5)
            throw new RuntimeException("400");
        else if (random < 10) {
            throw new RuntimeException("500");
        }
    }
}
