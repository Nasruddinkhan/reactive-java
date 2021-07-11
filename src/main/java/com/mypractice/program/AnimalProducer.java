package com.mypractice.program;

import com.mypractice.util.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class AnimalProducer implements Consumer<FluxSink<String>> {
    FluxSink<String> stringFluxSink;
    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.stringFluxSink = stringFluxSink;
    }

    public void produce(){
       String name = Util.faker().animal().name();
       this.stringFluxSink.next(Thread.currentThread().getName()+" : "+name);
    }
}
