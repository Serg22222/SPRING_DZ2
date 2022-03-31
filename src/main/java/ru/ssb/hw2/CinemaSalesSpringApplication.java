package ru.ssb.hw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.ssb.hw2.services.PremiereService;
import ru.ssb.hw2.model.Premiere;

@SpringBootApplication
public class CinemaSalesSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CinemaSalesSpringApplication.class, args);

        PremiereService premiereService = ctx.getBean(PremiereService.class);

        System.out.println("\n***Добавили 2-е премьеры***");
        premiereService.addPremiere(new Premiere("Крик", "2022, детектив, триллер, ужасы , США", 10, 100));
        premiereService.addPremiere(new Premiere("King's Man: Начало", "2021, боевик, комедия, приключения , Чехия, Великобритания, США", 6, 100));

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getPremieres().get(i).toString());
        }

        System.out.println("\n***Изменили кол-во доступных мест в премьере \"Крик\"***");
        premiereService.changePremiere("Крик", null, 0, 150);
        System.out.println(premiereService.getPremieres().get(0).toString());


        System.out.println("\n***Добавлена новая премьера \"Звёздный разум\"***");
        premiereService.addPremiere(new Premiere("Звёздный разум", "2021, приключения, фантастика , Россия", 10, 90));

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getPremieres().get(i).toString());
        }

        System.out.println("\n***Удалена премьера \"King's Man: Начало\"***");
        premiereService.deletePremiere("King's Man: Начало");
        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getPremieres().get(i).toString());
        }

        System.out.println("\n***Куплено 20 билетов на премьеру \"Крик\"***");
        if (!premiereService.buyTickets("Крик", 20)) {
            System.out.println("Все билеты на премьру \"Крик\" выкуплены");
        }

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getPremieres().get(i).toString());
        }

        System.out.println("\n***Вернули 5 билетов на премьеру \"Крик\"***");
        premiereService.returnTickets("Крик", 5);

        for (int i = 0; i < premiereService.getListPremiereSize(); i++) {
            System.out.println(premiereService.getPremieres().get(i).toString());
        }

        System.out.println("\n***Вывод информации о премьере \"Звёздный разум\"***");
        System.out.println(premiereService.getPremeiresInfo("Звёздный разум"));

        System.out.println("\n***Вывод информации обо всех премьерах***");
        System.out.println(premiereService.getPremeiresInfo(null));

    }

}
