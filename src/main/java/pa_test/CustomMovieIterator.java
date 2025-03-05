package pa_test;

import pa_test.entities.Movie;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Sergei Aleshchenko
 */
public class CustomMovieIterator implements Iterator<Movie> {

    private int currentIndex;
    private final List<Movie> list;

    public CustomMovieIterator(List<Movie> list) {
        this.list = list;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < list.size()) {
            Movie currentMovie = list.get(currentIndex);
            if (isMovieEligible(currentMovie)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Movie next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list.get(currentIndex++);
    }

    private boolean isMovieEligible(Movie currentMovie) {
        return currentMovie.getRating() >= 8;
    }
}
