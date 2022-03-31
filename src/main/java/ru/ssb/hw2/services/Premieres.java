package ru.ssb.hw2.services;

import org.springframework.stereotype.Component;
import ru.ssb.hw2.model.Premiere;

import java.util.ArrayList;
import java.util.List;

@Component
public class Premieres {
    private final List<Premiere> list;

    public Premieres() {
        list = new ArrayList<>();
    }

    public List<Premiere> getList() {
        return list;
    }

}
