package dev.folomkin.javaservletdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/init")
public class InitDB extends HttpServlet {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Драйвер SQLite не загружен", e);
        }
    }

    private String getDatabasePath() {
        String appPath = getServletContext().getRealPath("/");
        return appPath + "database.db";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contextPath = request.getContextPath();
        response.getWriter().println("context path: " + contextPath);

        String DB_URL = "jdbc:sqlite:" + getDatabasePath();
        // далее работа с БД

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            // Принудительно создаём таблицу
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY, name TEXT)");
            }

            // Проверка файла
            File dbFile = new File(getDatabasePath());
            System.out.println("БД создана: " + dbFile.exists());
            System.out.println("Путь: " + dbFile.getAbsolutePath());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
