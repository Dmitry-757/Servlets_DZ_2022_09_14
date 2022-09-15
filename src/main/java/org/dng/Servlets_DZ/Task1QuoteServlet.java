package org.dng.Servlets_DZ;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Task1Servlet", value = "/Task1Quote")
public class Task1QuoteServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Task1Quote.jsp");
        dispatcher.forward(request, response);
    }

    public void destroy() {
    }
}