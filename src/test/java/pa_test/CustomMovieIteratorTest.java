package pa_test;

import org.junit.Test;
import pa_test.entities.Movie;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sergei Aleshchenko
 */
public class CustomMovieIteratorTest {

    @Test
    public void givenMovieList_whenMovieIteratorUsed_thenOnlyHighRatedMovies() {
        List<Movie> movies = getMovieList();
        CustomMovieIterator movieIterator = new CustomMovieIterator(movies);

        int count = 0;
        while (movieIterator.hasNext()) {
            movieIterator.next();
            count++;
        }

        assertEquals(movies.size(), 6);
        assertEquals(count, 3);
    }


    private List<Movie> getMovieList() {
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("Name1", "Director1", 8));
        movieList.add(new Movie("Name2", "Director2", 3));
        movieList.add(new Movie("Name3", "Director3", 9));
        movieList.add(new Movie("Name4", "Director4", 5));
        movieList.add(new Movie("Name5", "Director5", 7));
        movieList.add(new Movie("Name6", "Director6", 8));

        return movieList;
    }
}