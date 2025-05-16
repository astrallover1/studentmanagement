package com.kandha.controller;

import java.io.*;
import java.sql.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "root");

            PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        res.sendRedirect("ViewStudentServlet");
    }
}
