<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="System.model.Task" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Tasks</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .edit-button {
            padding: 5px 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .edit-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2 style="text-align: center;">Employee Tasks</h2>
    <table>
        <thead>
            <tr>
                <th>Task ID</th>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Task Date</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Task Category</th>
                <th>Duration</th>
                <th>Description</th>
                <th>Approval Status</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.taskId}</td>
                    <td>${task.projectId}</td>
                    <td>${task.projectName}</td>
                    <td>${task.taskDate}</td>
                    <td>${task.startTime}</td>
                    <td>${task.endTime}</td>
                    <td>${task.taskCategory}</td>
                    <td>${task.duration}</td>
                    <td>${task.description}</td>
                    <td>${task.approvalStatus}</td>
                    <td><button class="edit-button" onclick="location.href='EditTaskServlet?taskId=${task.taskId}'">Edit</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>