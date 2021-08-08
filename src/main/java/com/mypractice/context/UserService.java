package com.mypractice.context;

import reactor.util.context.Context;

import java.util.Map;
import java.util.function.Function;

public class UserService {
    private static  Map<String, String> map = Map.of("Nasruddin", "user", "Jalaluddin","prime");

    public static Function<Context, Context> userCategery(){
        return ctx->{
           String user = ctx.get("user").toString();
           String category = map.get(user);
           return ctx.put("category", category);
        };
    }
}
