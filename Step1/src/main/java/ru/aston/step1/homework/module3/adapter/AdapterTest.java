package ru.aston.step1.homework.module3.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class AdapterTest {
    static void main() {
        int count = 10;
        List<Integer> numbers = new ArrayList<>();
        RandomGenerator randomGenerator = RandomGenerator.getDefault();
        for(int i = 0; i < count; i++){
            numbers.add( randomGenerator.nextInt(0, 50));
        }


        final List<Integer> sort = new SorterAdapter().sort(numbers);
        System.out.println(numbers);
        System.out.println(sort);
    }
}
