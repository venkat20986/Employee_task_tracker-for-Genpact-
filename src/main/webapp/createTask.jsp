<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="System.model.Project" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Task</title>
    <style>
        /* Your styles here */
    </style>
</head>
<body>
    <h2>Create Task</h2>
    <form action="TaskServlet" method="post">
        <table>
            <tr>
                <td>Project:</td>
                <td>
                    <select name="projectId">
                        <%
                            @SuppressWarnings("unchecked")
                            List<Project> projects = (List<Project>) request.getAttribute("projects");
                            for (Project project : projects) {
                        %>
                        <option value="<%= project.getProjectId() %>"><%= project.getProjectName() %></option>
                        <%
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Task Date:</td>
                <td><input type="date" name="taskDate" required></td>
            </tr>
            <tr>
                <td>Start Time:</td>
                <td><input type="time" name="startTime" required></td>
            </tr>
            <tr>
                <td>End Time:</td>
                <td><input type="time" name="endTime" required></td>
            </tr>
            <tr>
                <td>Task Category:</td>
                <td><input type="text" name="taskCategory" required></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Create Task"></td>
            </tr>
        </table>
    </form>
</body>
</html>