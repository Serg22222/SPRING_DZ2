package ru.ssb.hw2.model;

public class Premiere {

    private final String name;
    private String description;
    private Integer ageCategory;
    private Integer numberOfSeats;

    public Premiere(String name, String description, Integer ageCategory, Integer numberOfSeats) {
        this.name = name;
        this.description = description;
        this.ageCategory = ageCategory;
        this.numberOfSeats = numberOfSeats;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAgeCategory(Integer ageCategory) {
        if (ageCategory > 0) {
            this.ageCategory = ageCategory;
        }
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        if (numberOfSeats > 0) {
            this.numberOfSeats = numberOfSeats;
        }
    }

    @Override
    public String toString() {
        return "Премьера{" +
                "Наименование='" + name + '\'' +
                ", Описание='" + description + '\'' +
                ", Возрастная категория=" + ageCategory +
                ", Количестиво доступных мест=" + numberOfSeats +
                '}';
    }
}
