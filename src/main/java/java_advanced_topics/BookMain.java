package java_advanced_topics;

import java.util.*;

/**
 * @author Sergei Aleshchenko
 */
public class BookMain {
    public static void main(String[] args) {
//        List<Book> books = new ArrayList<>();
        Map<Book, Integer> books = new HashMap<>();


        books.put(new Book(1, "The Lord of the Rings", "J. R. R. Tolkien"), 7);
        books.put(new Book(2, "Le Petit Prince", "Antoine de Saint-Exupery"), 12);
        books.put(new Book(3, "Harry Potter and the Philosopher's Stone", "J. K. Rowling"), 3);
        books.put(new Book(4, "And Then There Were None", "Agatha Christie"), 46);
        books.put(new Book(5, "Dream of the Red Chamber", "Cao Xueqin"), 6);
        books.put(new Book(6, "The Hobbit", "J. R. R. Tolkien"), 8);
        books.put(new Book(7, "She: A History of Adventure", "H. Rider Haggard"), 99);
        books.put(new Book(8, "The Lion, the Witch and the Wardrobe", "C. S. Lewis"), 34);
        books.put(new Book(9, "The Da Vinci Code", "Dan Brown"), 11);
        books.put(new Book(10, "The Catcher in the Rye", "J. D. Salinger"),15);
        books.put(new Book(11, "The Hobbit", "A. A. Milne"), 44);
        books.put(new Book(12, "The Hobbit", "B. A. Milne"), 89);


//        Collections.sort(books, Comparator.comparingInt(Book::getId));
//        books.stream().forEach(System.out::println);


        Integer result = books.get(new Book(9, "The Da Vinci Code", "Dan Brown"));
        System.out.println(result);


    }
}
