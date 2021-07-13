package com.mypractice.transform;

import reactor.core.publisher.Flux;

public class UserService {
    public static Flux<User> getUser() {
        return Flux.range(1, 3)
                .map(User::new);
    }
}
