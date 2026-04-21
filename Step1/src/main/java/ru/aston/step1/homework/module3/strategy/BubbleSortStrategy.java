package ru.aston.step1.homework.module3.strategy;

public class BubbleSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] numbers) {
        int length = numbers.length -1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++)
                if (numbers[j + 1] < numbers[j]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
        }
    }
}
