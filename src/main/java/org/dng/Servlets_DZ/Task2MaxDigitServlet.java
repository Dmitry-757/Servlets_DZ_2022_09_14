package org.dng.Servlets_DZ;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Task2MaxDigitServlet", value = "/Task2MaxDigit")
public class Task2MaxDigitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Task2MaxDigit.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post");
        boolean error=false;
        int number1=0; int number2=0; int number3=0; int maxNumber=0;
        if(request.getParameter("digit1")!=""){
            number1 = Integer.parseInt(request.getParameter("digit1"));
        }
        else{
            error = true;
        }
        if(request.getParameter("digit2")!=""){
            number2 = Integer.parseInt(request.getParameter("digit2"));
        }
        else{
            error = true;
        }
        if(request.getParameter("digit3")!=""){
            number3 = Integer.parseInt(request.getParameter("digit3"));
        }
        else{
            error = true;
        }

        if (!error){
            maxNumber = Math.max(number1, number2);
            maxNumber = Math.max(maxNumber, number3);
            request.setAttribute("result", maxNumber);
            request.setAttribute("number1", number1);
            request.setAttribute("number2", number2);
            request.setAttribute("number3", number3);
        }
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Task2MaxDigit.jsp");
        dispatcher.forward(request, response);
    }
}
