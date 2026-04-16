package ru.aston.step1.homework.module2;


public record Book(String title, String author, int year, int pages) implements Comparable<Book> {
    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.pages, o.pages);
    }
}
