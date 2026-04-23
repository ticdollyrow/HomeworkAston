package ru.aston.step1.homework.module3.decorator;

public class DecoratorTest {
    static void main() {
        Component basicModel = new BasicModel();
        Component classA = new ModelClassA(basicModel);
        System.out.println(classA.getDescription());
    }
}
