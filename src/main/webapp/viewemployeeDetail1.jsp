<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Detail</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            background-image: url('images/bank_image.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .detail-container {
            width: 60%;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .detail-item {
            margin: 10px 0;
        }
        .detail-item span {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="detail-container">
        <h2>Employee Details</h2>
        <div class="detail-item">
            <span>Employee ID:</span> ${employeeDetails.employeeId}
        </div>
        <div class="detail-item">
            <span>Username:</span> ${employeeDetails.username}
        </div>
        <div class="detail-item">
            <span>Full Name:</span> ${employeeDetails.fullname}
        </div>
        <div class="detail-item">
            <span>Role:</span> ${employeeDetails.role}
        </div>
        <div class="detail-item">
            <span>Email:</span> ${employeeDetails.email}
        </div>
        <div class="detail-item">
            <span>Phone Number:</span> ${employeeDetails.phoneNumber}
        </div>
        <div class="detail-item">
            <span>Date of Birth:</span> ${employeeDetails.dob}
        </div>
        <div class="detail-item">
            <span>Address:</span> ${employeeDetails.address}
        </div>
        <div class="detail-item">
            <span>Date of Joining:</span> ${employeeDetails.dateOfJoining}
        </div>
    </div>
</body>
</html>