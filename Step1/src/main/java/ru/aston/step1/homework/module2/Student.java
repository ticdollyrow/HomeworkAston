package ru.aston.step1.homework.module2;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastname;
    private List<Book> books;

    public Student(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        if(book != null){
            books.add(book);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                " count of books = " + books.size() +
                "}" ;
    }

    public List<Book> getBooks() {
        return books;
    }
}
