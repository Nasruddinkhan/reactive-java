package com.mypractice.transform;

import com.mypractice.util.Util;

public class FlatMap {
    public static void main(String[] args) {

        UserService.getUser()
                .flatMap(user -> OrderService.getOrderFlux(user.getUserId())) //mono //flux
                .subscribe(Util.subscriber());
    Util.sleepSeconds(6);
    }
}
