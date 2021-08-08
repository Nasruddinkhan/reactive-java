package com.mypractice.context;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.HashMap;
import java.util.Map;

public class FirstContext {
    public static void main(String[] args) {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("user", "Nasruddin khan");

        getMessage()
                .contextWrite(Context.of(stringStringMap))
                .subscribe(Util.subscriber());
    }

    public static Mono<String> getMessage(){
     return    Mono.deferContextual(ctx->{
            if(ctx.hasKey("user")){
            return Mono.just("welcome "+ctx.get("user"));
            }else {
                return Mono.error(new RuntimeException("unauthentication"));
            }
        });
    }
}
