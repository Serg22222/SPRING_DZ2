package ru.ssb.hw2.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.ssb.hw2.event.EvenInfo;
import ru.ssb.hw2.event.PremiereEvent;
import ru.ssb.hw2.model.Premiere;

import java.util.List;

@Service
public class PremiereService implements ApplicationContextAware {

    private final Premieres premieres;
    private ApplicationContext ctx;

    @Autowired
    public PremiereService(Premieres premieres) {
        this.premieres = premieres;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    public void addPremiere(Premiere premiere) {
        premieres.getList().add(premiere);
        ctx.publishEvent(new PremiereEvent(new EvenInfo(premiere, new Throwable().getStackTrace()[0].getMethodName())));
    }

    public void deletePremiere(String premiereName) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                premieres.getList().remove(p);
                ctx.publishEvent(new PremiereEvent(new EvenInfo(p, new Throwable().getStackTrace()[0].getMethodName())));
                return;
            }
        }
    }

    public boolean buyTickets(String premiereName, Integer numTikets) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName) && p.getNumberOfSeats() - numTikets >= 0) {
                p.setNumberOfSeats(p.getNumberOfSeats() - numTikets);
                ctx.publishEvent(new PremiereEvent(new EvenInfo(p, new Throwable().getStackTrace()[0].getMethodName())));
                return true;
            }
        }
        return false;
    }

    public void changePremiere(String premiereName,
                               String newDescription,
                               Integer newAgeCategory,
                               Integer newNumberOfSeats) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                if (newDescription != null) {
                    p.setDescription(newDescription);
                }
                p.setAgeCategory(newAgeCategory);
                p.setNumberOfSeats(newNumberOfSeats);
            }
        }
    }

    public void returnTickets(String premiereName, Integer numTikets) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                p.setNumberOfSeats(p.getNumberOfSeats() + numTikets);
            }
        }
    }

    public List<Premiere> getPremieres() {
        return premieres.getList();
    }

    public int getListPremiereSize() {
        return premieres.getList().size();
    }

    public String getPremeiresInfo(String premiereName) {
        StringBuilder sb = new StringBuilder();
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                return p.toString();
            } else {
                sb.append(p).append("\n");
            }

        }
        return sb.toString();
    }
}
