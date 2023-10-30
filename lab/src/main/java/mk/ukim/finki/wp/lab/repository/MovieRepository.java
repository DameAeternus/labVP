package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    List<Movie> movieList = new ArrayList<>();

    public MovieRepository() {
        movieList.add(new Movie("Movie 1", "2023",3));
        movieList.add(new Movie("Movie 2", "2022",2));
        movieList.add(new Movie("Movie 3", "2022",7));
        movieList.add(new Movie("Movie 4", "2022",9));
        movieList.add(new Movie("Movie 5", "2024",2));
        movieList.add(new Movie("Movie 6", "2022",1));
        movieList.add(new Movie("Movie 7", "2020",7));
        movieList.add(new Movie("Movie 8", "2021",9));
        movieList.add(new Movie("Movie 9", "2023",4));
        movieList.add(new Movie("Movie 10", "2012",5));
    }
    public List<Movie> findAll(){
        return movieList;
    }
    public List<Movie> searchMovies(String text) {
        List<Movie> result = new ArrayList<>();

        for (Movie movie : movieList) {
            // Check if the movie's title or description contains the given text
            if (movie.getTitle().contains(text) || movie.getSummary().contains(text)) {
                result.add(movie);
            }
        }

        return result;
    }
}
