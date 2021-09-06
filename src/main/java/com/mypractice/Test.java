package com.mypractice;

import java.util.List;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
       List<Integer> list =  List.of(10,2,5);
       var sum = 0;
        for (int no: list) {
            sum +=no *2 ;
        }
        System.out.println("Test.main ["+sum+"]");
       var num = IntStream.of(10,2,5).map(no -> no * 2).sum();
        System.out.println("Test.main ["+num+"]");
    }

}
