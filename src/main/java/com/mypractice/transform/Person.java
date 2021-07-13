package com.mypractice.transform;

import com.mypractice.util.Util;

public class Person {
    private int age;
    private String name;

    public Person() {
        this.age = Util.faker().random().nextInt(1, 30);
        this.name = Util.faker().name().fullName();
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
