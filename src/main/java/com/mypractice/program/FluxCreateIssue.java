package com.mypractice.program;

import com.mypractice.util.Util;
import reactor.core.publisher.Flux;

public class FluxCreateIssue {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String name;
            do{
                name= Util.faker().animal().name();
                System.out.println("FluxCreateIssue.main ["+name+"]");
                fluxSink.next(name);

            }while ( !name.equalsIgnoreCase("rat") && !fluxSink.isCancelled());
        }).take(5).subscribe(Util.subscriber());

    }
}
