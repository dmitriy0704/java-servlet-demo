package dev.folomkin.javaservletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/calc.jsp").forward(request, response);

//        String path = "/calc.jsp";
//        ServletContext context = getServletContext();
//        RequestDispatcher dispatcher = context.getRequestDispatcher(path);
//        dispatcher.forward(request, response);

    }

    public void destroy() {
    }
}