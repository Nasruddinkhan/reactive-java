package com.mypractice.sinks;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {
    private String name;
    private Sinks.Many<SlackMessage> sink;
    private Flux<SlackMessage> flux;

    public SlackRoom(String name) {
        this.name = name;
        this.sink = Sinks.many().replay().all();
        this.flux = this.sink.asFlux();
    }

    public void joinRoom(SlackMember slackMember) {
        System.out.println(slackMember.getName() + "----- joined ----");

    }

    private void subscribe(SlackMember slackMember) {
        this.flux
                .doOnNext(sm -> sm.setReciver(slackMember.getName()))
                .map(SlackMessage::toString)
                .subscribe(slackMember::receives);
    }

    public void postMessage(SlackMember slackMember, String msg) {
        System.out.println(slackMember.getName() + "----- joined ----");
        SlackMessage slackMessage = new SlackMessage();
        slackMessage.setSender(slackMember.getName());
        slackMessage.setMsg(msg);
        this.sink.tryEmitNext(slackMessage);
    }
}
