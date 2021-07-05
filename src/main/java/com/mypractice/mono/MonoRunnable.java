package com.mypractice.mono;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;

public class MonoRunnable {
    public static void main(String[] args) {
        Mono.fromRunnable(MonoRunnable::timeConsumingProcess).subscribe(Util.onNext(),
                Util.onError(),
                ()-> System.out.println("process done sending email or notification")
                );

    }
    private static Runnable timeConsumingProcess()  {
        return ()->{
            Util.sleepSeconds(3);
            System.out.println("Operation Complete");
        };
    }
}
