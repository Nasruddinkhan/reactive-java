package com.mypractice.flux;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    /*public static List<String> getName(int count){
        var namse=new ArrayList<String>();
        for (var i=0; i<count; i++){
            namse.add(getName());
        }
        return namse;
    }
*/
    public static Flux<String> getName(int count){
       return Flux.range(0, count).map(i->getName());
    }
    private static String  getName(){
       // Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
