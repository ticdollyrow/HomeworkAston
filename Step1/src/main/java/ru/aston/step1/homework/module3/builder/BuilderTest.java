package ru.aston.step1.homework.module3.builder;

public class BuilderTest {
    static void main() {
        final User john = new User.UserBuilder().setName("John")
                .build();

        System.out.println(john);

        final User mara = new User.UserBuilder().setName("Mara")
                .setEmail("mara@mail.ru")
                .build();

        System.out.println(mara);
    }
}
