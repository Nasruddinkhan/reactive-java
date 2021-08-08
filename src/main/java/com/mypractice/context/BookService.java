package com.mypractice.context;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BookService {

    private static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("user",5);
        map.put("prime",2);

    }
    public static Mono<String> getBook(){
        return Mono.deferContextual(contextView -> {
            if (contextView.get("allow")){
                return Mono.just(Util.faker().book().title());
            }else {
                return Mono.error(new RuntimeException("not allowed"));
            }
        }).contextWrite(rateLimitor());
    }
    public static Function<Context, Context> rateLimitor(){
        return ctx->{
            if(ctx.hasKey("category")){
              String category =  ctx.get("category");
              Integer attempt = map.get(category);
              if(attempt > 0){
                  map.put(category, attempt -1);
                  return ctx.put("allow", true);
              }

            }

            return ctx.put("allow", false);
        };
    }
}
