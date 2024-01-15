package classes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class FilteringIterator<E> implements Iterator<E> {

    private final Predicate<E> filter;
    private final Iterator<E> unfiltered;

    public FilteringIterator(Predicate<E> filter, Iterator<E> unfiltered) {
        this.filter = filter;
        this.unfiltered = unfiltered;
    }

    /**
     * @return true if there is at least one element in
     * the unfiltered iterator for which
     * filter.test(element) == true,
     * false otherwise.
     **/
    @Override
    public boolean hasNext() {
        //todo: implement

        while (unfiltered.hasNext()) {
            if (filter.test(unfiltered.next())) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return the next element from iterator for which
     * filter.test(element) == true,
     * throws NoSuchElementException if there is no such element
     **/
    @Override
    public E next() {
        //todo: implement
        E next = unfiltered.next();
        boolean result = false;

        while (unfiltered.hasNext()) {
            if (filter.test(next)) {
                result = true;
                break;
            }
            next = unfiltered.next();
        }

        if (result) {
            return next;
        } else {
            throw new NoSuchElementException();
        }
    }
}
