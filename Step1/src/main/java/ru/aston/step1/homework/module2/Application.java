package ru.aston.step1.homework.module2;


public class Application {
    static void main() {
        StudentReader reader = new FileStudentReader();
        var students = reader.fill();

        int yearFilter = 2000;
        int limitSize = 3;
        students.stream()
                .peek(System.out::println)
                .flatMap((student -> student.getBooks().stream()))
                .sorted()
                .distinct()
                .filter(book -> book.year() > yearFilter)
                .limit(limitSize)
                .map(Book::year)  // Получить из книг годы выпуска
                .findFirst()  //вернуть Optional от года
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Книга отсутствует") )
                ;
    }
}
