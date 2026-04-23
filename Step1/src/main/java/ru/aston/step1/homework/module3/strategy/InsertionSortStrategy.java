package ru.aston.step1.homework.module3.strategy;

public class InsertionSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] numbers) {
        int length = numbers.length;
        for (int i = 1; i < length; i++) {
            int tmp = numbers[i];
            int j = i -1;
            for (; j >= 0 && numbers[j] > tmp; j--) {
                numbers[j+1] = numbers[j];
            }
            numbers[j+1] = tmp;
        }
    }
}
