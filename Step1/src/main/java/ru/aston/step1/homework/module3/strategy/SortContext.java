package ru.aston.step1.homework.module3.strategy;

import java.util.Arrays;
import java.util.random.RandomGenerator;

public class SortContext {
    static void main() {
        int length = 10;
        int[] numbers = new int[length];
        RandomGenerator randomGenerator = RandomGenerator.getDefault();
        for(int i = 0; i < length; i++){
            numbers[i] = randomGenerator.nextInt(0, 50);
        }
        int[] numbers2 = numbers.clone();
        int[] numbers3 = numbers.clone();


        execute(new SelectionSortStrategy(), numbers);
        System.out.println(Arrays.toString(numbers));
        execute(new BubbleSortStrategy(), numbers2);
        System.out.println(Arrays.toString(numbers2));
        execute(new InsertionSortStrategy(), numbers3);
        System.out.println(Arrays.toString(numbers3));
    }

    public static void execute(SortStrategy strategy,  int[] numbers){
        strategy.sort( numbers);
    }
}
