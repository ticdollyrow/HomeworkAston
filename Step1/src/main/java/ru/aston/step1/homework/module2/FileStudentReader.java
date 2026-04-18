package ru.aston.step1.homework.module2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileStudentReader implements StudentReader {
    @Override
    public List<Student> fill() {
        List<Student> students;
        try {
            URI studentURI = getClass().getResource("/students.txt")
                    .toURI();
            Path path = Paths.get(studentURI);
            if (!Files.exists(path)) {
                throw new FileNotFoundException("File students.txt not found");
            }

            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            students = fillStudents(lines);

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return students;
    }

    private List<Student> fillStudents(List<String> lines) {
        List<Student> students = new ArrayList<>();

        boolean isNew = true;
        Student student = null;

        Pattern studentPattern = Pattern.compile("^(.+)\\|(.+)$");  // firstName|lastname
        Pattern bookPattern = Pattern.compile("^(.+)\\|(.+)\\|(\\d+)\\|(\\d+)$"); //title|author|year|pages
        for (String line : lines) {
            if (line.isBlank()) {
                isNew = true;
                continue;
            }

            if (isNew) {
                isNew = false;
                Matcher studentMatcher = studentPattern.matcher(line);
                if (studentMatcher.matches()) {
                    student = new Student(studentMatcher.group(1)
                            .trim(), studentMatcher.group(2)
                            .trim());
                    students.add(student);
                }
                continue;
            }

            Matcher bookMatcher = bookPattern.matcher(line);
            if (bookMatcher.matches()) {
                Book book = new Book(bookMatcher.group(1),
                        bookMatcher.group(2),
                        Integer.parseInt(bookMatcher.group(3)),
                        Integer.parseInt(bookMatcher.group(4)));

                assert student != null;
                student.addBook(book);
            }


        }

        return students;
    }
}
