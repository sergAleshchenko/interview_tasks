package java_advanced_topics;

import java.util.Comparator;

/**
 * @author Sergei Aleshchenko
 */
public class Book implements Comparable<Book> {
    public static class ReverseTitleComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return -o1.getTitle().compareTo(o2.getTitle());
        }
    }

    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }

    @Override
    public int compareTo(Book o) {
        int result = this.title.compareTo(o.title);
        if (result != 0) return result;

        return this.author.compareTo(o.author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return author != null ? author.equals(book.author) : book.author == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
