package ru.aston.step1.homework.module3.chainOfResponsibility;

public enum Ware {
    CHEESE("Cheese"),
    BREAD("BREAD"),
    MILK("Milk");

    final private String description;

    Ware(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Ware{" +
                "description='" + description + '\'' +
                '}';
    }
}
