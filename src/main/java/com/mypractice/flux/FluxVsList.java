package com.mypractice.flux;

import com.mypractice.util.Util;

public class FluxVsList {
    public static void main(String[] args) {
        /*var listName = NameGenerator.getName(5);
        System.out.println("FluxVsList.main ["+listName+"]");
        */
        NameGenerator.getName(5).subscribe(Util.onNext());
    }
}
