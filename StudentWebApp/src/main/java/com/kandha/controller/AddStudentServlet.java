package com.kandha.controller;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String course = req.getParameter("course");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "root");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students (name, age, course) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.executeUpdate();
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        res.sendRedirect("ViewStudentServlet");
    }
}
