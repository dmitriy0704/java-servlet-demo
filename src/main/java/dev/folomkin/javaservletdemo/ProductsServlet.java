package dev.folomkin.javaservletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            String url = "jdbc:postgresql://localhost:5432/java_servlet?currentSchema=productdb";
            String username = "postgres";
            String password = "dv9899";
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                writer.println("Connection to ProductDB succesfull!");
            }
        } catch (Exception ex) {
            writer.println("Connection failed...");
            writer.println(ex);
        } finally {
            writer.close();
        }
    }

}
