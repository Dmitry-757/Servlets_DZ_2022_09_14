package org.dng.Servlets_DZ;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Task3MaxMinAvgDigit", value = "/Task3MaxMinAvgDigit")
public class Task3MaxMinAvgDigit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Task3MaxMinAvgNumber.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("do post");
        boolean error = false;
        int number1 = 0;
        int number2 = 0;
        int number3 = 0;
        String choice = "";
        if (
                request.getParameter("number1") != null && request.getParameter("number1") != "" &&
                        request.getParameter("number2") != null && request.getParameter("number2") != "" &&
                        request.getParameter("number3") != null && request.getParameter("number3") != "" &&
                        request.getParameter("choice") != null && request.getParameter("choice") != ""
        ) {
            number1 = Integer.parseInt(request.getParameter("number1"));
            number2 = Integer.parseInt(request.getParameter("number2"));
            number3 = Integer.parseInt(request.getParameter("number3"));
            choice = request.getParameter("choice");
        } else {
            error = true;
        }

        if (!error) {
            String result;
            result = switch (choice) {
                case "max" -> {
                    int res = Math.max(number1, number2);
                    res = Math.max(res, number3);
                    yield "" + res;
                }
                case "min" -> {
                    int res = Math.min(number1, number2);
                    res = Math.min(res, number3);
                    yield "" + res;
                }
                case "avg" -> {
                    float res = (number1 + number2 + number3) / 3;
                    yield "" + res;
                }
                default -> "error";
            };

            request.setAttribute("choice", choice);
            request.setAttribute("result", result);
            request.setAttribute("number1", number1);
            request.setAttribute("number2", number2);
            request.setAttribute("number3", number3);

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Task3MaxMinAvgNumber.jsp");
            dispatcher.forward(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1> Something wrong! </h1>");
            out.println("<a style=font-size: x-large href="+request.getContextPath()+">main menu</a>");
            out.println("</body></html>");
        }
    }
}
