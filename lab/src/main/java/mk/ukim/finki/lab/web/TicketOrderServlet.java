package mk.ukim.finki.lab.web;

import mk.ukim.finki.wp.lab.model.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ticketOrder")
public class TicketOrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve order details from the request
        String clientName = req.getParameter("clientName");
        String clientIP = req.getRemoteAddr();
        String selectedMovie = req.getParameter("selectedMovie");
        int numTickets = Integer.parseInt(req.getParameter("numTickets"));

        // Store order details in a session for later retrieval
        HttpSession session = req.getSession();
        session.setAttribute("clientName", clientName);
        session.setAttribute("clientIP", clientIP);
        session.setAttribute("selectedMovie", selectedMovie);
        session.setAttribute("numTickets", numTickets);

        // Redirect to the confirmation page
        resp.sendRedirect(req.getContextPath() + "/confirmation");
    }
}
