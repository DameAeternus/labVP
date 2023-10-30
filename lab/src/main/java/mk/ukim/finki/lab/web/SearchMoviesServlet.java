package mk.ukim.finki.lab.web;

import mk.ukim.finki.wp.lab.model.Movie;
import mk.ukim.finki.wp.lab.service.MovieService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchMovies")
public class SearchMoviesServlet extends HttpServlet {
    private final MovieService movieService;

    public SearchMoviesServlet(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve search criteria from the request
        String searchText = req.getParameter("searchText");
        int minRating = Integer.parseInt(req.getParameter("minRating"));

        // Search for movies based on the criteria
        List<Movie> movies = movieService.searchMovies(searchText, minRating);

        // Set the search results as an attribute in the request
        req.setAttribute("searchResults", movies);

    }
}
