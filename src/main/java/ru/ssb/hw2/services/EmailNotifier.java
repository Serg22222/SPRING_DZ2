package ru.ssb.hw2.services;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.ssb.hw2.event.PremiereEvent;

@Component
public class EmailNotifier implements ApplicationListener<PremiereEvent> {

    @Override
    public void onApplicationEvent(PremiereEvent event) {

        String method = null;
        if (event.getEvenInfo().getMethod().equalsIgnoreCase("addPremiere")) {
            method = "Анонс фильма:";
        } else if (event.getEvenInfo().getMethod().equalsIgnoreCase("deletePremiere")) {
            method = "Перенос фильма:";
        } else if (event.getEvenInfo().getMethod().equalsIgnoreCase("buyTickets")) {
            method = "Покупка билетов на фильм:";
        }

        System.out.println("<< SEND EMAIL (Event) >> " + method + " Фильм '" + event.getEvenInfo().getPremiere().getName() + "'");
    }
}
