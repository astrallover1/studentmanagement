<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Add Student</title></head>
<body>
    <h2>Add New Student</h2>
    <form action="AddStudentServlet" method="post">
        Name: <input type="text" name="name" required><br>
        Age: <input type="number" name="age" required><br>
        Course: <input type="text" name="course" required><br>
        <button type="submit">Add</button>
    </form>
</body>
</html>
