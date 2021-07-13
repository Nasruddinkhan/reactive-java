package com.mypractice.operator;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FluxFirstCallBack {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            for (int i = 0; i < 15; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        }).doOnComplete(() -> System.out.println("FluxFirstCallBack.main doOnComplete"))
                .doFirst(() -> System.out.println("FluxFirstCallBack.main doFirst 1"))   //1 first call is do first
                .doOnNext(o -> System.out.println("FluxFirstCallBack.main doOnNext" + o))
                .doOnSubscribe(o -> System.out.println("FluxFirstCallBack.main doOnSubscribe" + o)) //2 call the on subscriber
                .doOnRequest(o -> System.out.println("FluxFirstCallBack.main doOnRequest" + o))
                .doFirst(() -> System.out.println("FluxFirstCallBack.main doFirst 2"))   //1 first call is do first

                .doOnError(o -> System.out.println("FluxFirstCallBack.main doOnError" + o.getMessage()))
                .doOnTerminate(() -> System.out.println("FluxFirstCallBack.main doOnTerminate"))
                .doOnComplete(() -> System.out.println("FluxFirstCallBack.main doOnComplete"))
                .doFinally(c -> System.out.println("FluxFirstCallBack.main doFinally" + c))
                .doFirst(() -> System.out.println("FluxFirstCallBack.main doFirst 3"))   //1 first call is do first

                .doOnDiscard(Object.class, o -> System.out.println("FluxFirstCallBack.main doOnDiscard" + o))
                .subscribe(Util.subscriber());
    }
}
