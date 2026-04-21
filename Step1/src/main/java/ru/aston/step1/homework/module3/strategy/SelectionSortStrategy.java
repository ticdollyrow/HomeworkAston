package ru.aston.step1.homework.module3.strategy;

public class SelectionSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] numbers) {
        int length = numbers.length;

        for (int i = 0; i < length; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if (numbers[index] > numbers[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int tmp = numbers[i];
                numbers[i] = numbers[index];
                numbers[index] = tmp;
            }
        }
    }
}
