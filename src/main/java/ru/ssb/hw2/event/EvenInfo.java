package ru.ssb.hw2.event;

import ru.ssb.hw2.model.Premiere;

public class EvenInfo {

    private final Premiere premiere;
    private final String method;

    public EvenInfo(Premiere premiere, String method) {
        this.premiere = premiere;
        this.method = method;
    }

    public Premiere getPremiere() {
        return premiere;
    }

    public String getMethod() {
        return method;
    }
}