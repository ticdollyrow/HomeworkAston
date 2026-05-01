package ru.aston.step1.homework.module5;

import java.util.Comparator;
import java.util.Objects;

public class User implements Comparable<User> {

    final String name;
    final int age;
    final String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public int compareTo(User other) {
        int result;
        result = Comparator.comparing(User::getName)
                .thenComparingInt(User::getAge)
                .thenComparing(User::getEmail)
                .compare(this, other);

        return result;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, email);
    }
}
