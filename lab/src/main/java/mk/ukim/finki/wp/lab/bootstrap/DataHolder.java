package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Movie> categories = null;

    @PostConstruct
    public void init() {
        categories = new ArrayList<>();
        categories.add(new Movie("Movie12", "2011", 7));
        categories.add(new Movie("Movie13", "2010", 5));
    }
}
