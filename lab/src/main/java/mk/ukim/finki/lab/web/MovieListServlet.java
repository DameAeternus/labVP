package mk.ukim.finki.lab.web;

import jakarta.servlet.ServletException;

import mk.ukim.finki.wp.lab.service.MovieService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.IOException;


import static mk.ukim.finki.wp.lab.bootstrap.DataHolder.categories;

@WebServlet(urlPatterns = "/")
public class MovieListServlet extends HttpServlet {
    private final MovieService movieService;

    private final SpringTemplateEngine springTemplateEngine;

    public MovieListServlet(MovieService movieService, SpringTemplateEngine springTemplateEngine) {
        this.movieService = movieService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("categories", categories);
        context.setVariable("ipAddress", req.getRemoteAddr());

        springTemplateEngine.process(
                "listMovies.html",
                context,
                resp.getWriter()
        );

//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//
//        List<Movie> movies = movieService.listAll();
//
//        out.println("<html><head><title>Movie List</title></head><body>");
//        out.println("<h1>Movie List</h1>");
//
//        // Create a form for selecting a movie and specifying the number of tickets
//        out.println("<form method='post'>");
//        for (Movie movie : movies) {
//            out.println("<input type='radio' name='selectedMovie' value='" + movie.getTitle() + "'>");
//            out.println("Title: " + movie.getTitle() + ", Summary: " + movie.getSummary() + ", Rating: " + movie.getRating() + "<br>");
//        }
//        out.println("<input type='number' name='numTickets' placeholder='Number of Tickets' required>");
//        out.println("<input type='submit' value='Order Tickets'>");
//        out.println("</form>");
//
//        out.println("</body></html>");
    }
}
