package ru.aston.step1.homework.module5;

import java.util.Comparator;

public record Car(double power, String model, int year) implements Comparable<Car> {
    @Override
    public int compareTo(Car other) {
        return Comparator.comparingDouble(Car::power)
                .thenComparing(Car::model)
                .thenComparingInt(Car::year)
                .compare(this, other);
    }
}
