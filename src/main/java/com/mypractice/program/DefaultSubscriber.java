package com.mypractice.program;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {
    private String name ="";

    public DefaultSubscriber(String name) {
        this.name = name + " - ";
    }

    public DefaultSubscriber() {
    }
    @Override
    public void onSubscribe(Subscription s) {
        System.out.println("DefaultSubscriber.onSubscribe");
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println("Name :"+name + " DefaultSubscriber.onNext ["+o+"]");
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("Name :"+name + " DefaultSubscriber.onError ["+t.getMessage()+"]");
    }

    @Override
    public void onComplete() {
        System.out.println("Name :"+name + " DefaultSubscriber.onComplete");
    }
}
