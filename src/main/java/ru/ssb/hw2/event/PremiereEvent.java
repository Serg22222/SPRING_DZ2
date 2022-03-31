package ru.ssb.hw2.event;

import org.springframework.context.ApplicationEvent;

public class PremiereEvent extends ApplicationEvent {
    private final EvenInfo evenInfo;


    public PremiereEvent(EvenInfo evenInfo) {
        super(evenInfo);
        this.evenInfo = evenInfo;
    }

    public EvenInfo getEvenInfo() {
        return evenInfo;
    }
}