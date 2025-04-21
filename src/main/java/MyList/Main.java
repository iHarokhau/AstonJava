package MyList;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Александр", Arrays.asList(
                        new Book("Книга 1", 1998, 200),
                        new Book("Книга 2", 1995, 158),
                        new Book("Книга 3", 2001, 1000),
                        new Book("Книга 4", 2015, 250),
                        new Book("Книга 5", 1994, 100)
                )),
                new Student("Павел", Arrays.asList(
                        new Book("Гарри Поттер 1", 1997, 500),
                        new Book("Гарри Поттер 2", 1998, 565),
                        new Book("Гарри Поттер 3", 1999, 458),
                        new Book("Гарри Поттер 4", 2000, 478),
                        new Book("Гарри Поттер 5", 2001, 588)
                ))
        );
        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted((x1, x2) -> Integer.compare(x1.getLists(), x2.getLists()))
                .filter(book -> book.getYear() > 2000)
                .distinct()
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска книги:" + year),
                        () -> System.out.println("Книга не найдена")
                );
    }
}
