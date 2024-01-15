package java_advanced_topics;

import java.util.Comparator;

/**
 * @author Sergei Aleshchenko
 */
public class ReverseTitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
