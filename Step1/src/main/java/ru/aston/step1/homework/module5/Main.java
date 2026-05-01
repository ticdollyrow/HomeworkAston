package ru.aston.step1.homework.module5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static void main() {
        List<User> users = new ArrayList<>();
        users.add(new User("Inna", 16, "email@mail.ru"));
        users.add(new User("Inna", 12, "innna@mail.ru"));
        users.add(new User("Inna", 16, "apple@mail.ru"));
        users.add(new User("Alice", 16, "apple@mail.ru"));


        System.out.println(users);
        Collections.sort(users);
        System.out.println(users);
    }
}
