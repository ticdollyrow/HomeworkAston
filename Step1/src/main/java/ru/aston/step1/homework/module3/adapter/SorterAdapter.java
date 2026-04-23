package ru.aston.step1.homework.module3.adapter;

import ru.aston.step1.homework.module3.strategy.BubbleSortStrategy;

import java.util.Arrays;
import java.util.List;

public class SorterAdapter extends BubbleSortStrategy implements Sorter {

    @Override
    public List<Integer> sort(List<Integer> numbers) {
        int[] array = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            array[i] = numbers.get(i);
        }

        sort(array);
        return Arrays.stream(array)
                .boxed()
                .toList();
    }
}
