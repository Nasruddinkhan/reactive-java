package com.mypractice.combine.publisher;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class StartWith {

    public static void main(String[] args) {
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.generatorName().
                take(2)
                .subscribe(Util.subscriber("Nasruddin"));

        nameGenerator.generatorName().
                take(2)
                .subscribe(Util.subscriber("Jalaluddin"));

        nameGenerator.generatorName().
                take(3)
                .subscribe(Util.subscriber("Samsu"));

        nameGenerator.generatorName().
                filter(n-> n.startsWith("I"))
                .take(3)
                .subscribe(Util.subscriber("zaid"));
    }
}

class NameGenerator {

    private List<String> list = new ArrayList<>();

    public Flux<String> generatorName() {
        return Flux.generate(stringSynchronousSink -> {
            System.out.println("generate new name");
            Util.sleepSeconds(1);
            String name = Util.faker().name().name();
            stringSynchronousSink.next(name);
        }).cast(String.class)
                .startWith(getFromCache());
    }

    public Flux<String> getFromCache() {
        return Flux.fromIterable(list);
    }
}