package org.dng.Servlets_DZ;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Task5CalculatorServlet", value = "/Task5Calculator")
public class Task5CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Task5Calculator.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("do post");
        boolean error = false;
        float number1 = 0;
        float number2 = 0;


        if (
                request.getParameter("number1") != null && request.getParameter("number1") != "" &&
                        request.getParameter("number2") != null && request.getParameter("number2") != ""
        ) {
            number1 = Float.parseFloat(request.getParameter("number1"));
            number2 = Float.parseFloat(request.getParameter("number2"));
        } else {
            error = true;
        }

        String buttonAction = request.getParameter("buttonAction");



        if (!error) {
            String result;
            result = switch (buttonAction) {
                case "+" -> {
                    float res = number1 + number2;
                    yield "" + res;
                }
                case "-" -> {
                    float res = number1 - number2;
                    yield "" + res;
                }
                case "*" -> {
                    float res = number1 * number2;
                    yield "" + res;
                }
                case "/" -> {
                    float res = number1 / number2;
                    yield "" + res;
                }
                case "^" -> {
                    double res = Math.pow(number1, number2);
                    yield "" + res;
                }
                case "%" -> {
                    double res = number1 / 100 * number2;
                    yield "" + res;
                }

                default -> "error";
            };

            request.setAttribute("operation", buttonAction);
            request.setAttribute("result", result);
            request.setAttribute("number1", number1);
            request.setAttribute("number2", number2);

            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Task5Calculator.jsp");
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
