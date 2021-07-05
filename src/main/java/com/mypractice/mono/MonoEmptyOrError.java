package com.mypractice.mono;

import com.mypractice.util.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {
    public static void main(String[] args) {
        userRepo(1).subscribe(Util.onNext(),
                                    Util.onError(),
                                    Util.onComplete());
    }
    private static Mono<String> userRepo(int userId){
        if (userId ==1){
            return Mono.just(Util.faker().name().firstName());
        }else if(userId == 2){
            return Mono.empty();
        }else{
            return Mono.error(new RuntimeException("Not allowed !"));
        }


    }
}
