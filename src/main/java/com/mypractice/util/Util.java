package com.mypractice.util;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {
    private static final Faker FAKER = Faker.instance();

    private Util() {
    }

    public static Consumer<Object> onNext() {
        return item -> System.out.println("Received item [" + item + "]");
    }

    public static Consumer<Throwable> onError() {
        return error -> System.out.println("error  [" + error.getMessage() + "]");
    }

    public static Runnable onComplete() {
        return () -> System.out.println("complete");
    }

    public static void sleepSeconds(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Faker faker() {
        return FAKER;
    }
}
