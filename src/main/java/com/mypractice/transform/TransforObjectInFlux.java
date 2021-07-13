package com.mypractice.transform;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class TransforObjectInFlux {
    public static void main(String[] args) {
        getPerson()
                .transform(applyFilterMap())
                .subscribe(Util.subscriber());
    }

    public static Flux<Person> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return personFlux -> personFlux.filter(person -> person.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("TransforObjectInFlux.applyFilterMap not allow  [" + p + "]"));
    }
}
