package com.kandha.controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<String[]> studentList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "root");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                studentList.add(new String[]{
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("age"),
                    rs.getString("course")
                });
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("studentList", studentList);
        RequestDispatcher rd = req.getRequestDispatcher("view-students.jsp");
        rd.forward(req, res);
    }
}
