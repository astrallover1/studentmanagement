<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.sql.*" %>
<%@ page language="java" %>
<html>
<head><title>Students</title></head>
<body>
<h2>All Students</h2>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Age</th><th>Course</th><th>Delete</th></tr>
    <%
        List<String[]> students = (List<String[]>) request.getAttribute("studentList");
        for(String[] s : students) {
    %>
    <tr>
        <td><%= s[0] %></td>
        <td><%= s[1] %></td>
        <td><%= s[2] %></td>
        <td><%= s[3] %></td>
        <td><a href="DeleteStudentServlet?id=<%= s[0] %>">Delete</a></td>
    </tr>
    <% } %>
</table>
</body>
</html>

</html>