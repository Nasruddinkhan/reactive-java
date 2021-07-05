package com.mypractice.mono;

import com.github.javafaker.Faker;

public class FakerDemo {
    public static void main(String[] args) {
        for (var i = 0; i < 10 ; i++) {
            System.out.println(Faker.instance().name().fullName());
        }
    }
}
