<%@ page language="java" %>

<html>
<head>
    <title>Library Book Issue</title>

    <style>
        body {
            font-family: Arial;
            background: #eef2ff;
            padding: 20px;
        }

        .container {
            width: 700px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
        }

        h1 {
            background: #4338ca;
            color: white;
            text-align: center;
            padding: 15px;
            border-radius: 8px;
        }

        h3 {
            color: #4338ca;
            border-bottom: 2px solid #ddd;
            padding-bottom: 8px;
            margin-top: 25px;
        }

        .form {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        input, select {
            width: 100%;
            padding: 9px;
            border: 1px solid #bbb;
            border-radius: 5px;
        }

        .buttons {
            margin-top: 20px;
            text-align: center;
        }

        button, input[type="submit"], input[type="reset"] {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
        }

        input[type="submit"] {
            background: #4338ca;
            color: white;
        }

        input[type="reset"] {
            background: #ddd;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        td:first-child {
            width: 40%;
            font-weight: bold;
            background: #f0fdf4;
        }

        .success {
            color: #047857;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Library Book Issue</h1>

    <form method="post">

        <h3>Student Details</h3>

        <div class="form">

            <div>
                <label>Student Name</label>
                <input type="text"
                       name="student"
                       placeholder="Enter student name"
                       required>
            </div>

            <div>
                <label>Register Number</label>
                <input type="text"
                       name="regno"
                       placeholder="Enter register number"
                       required>
            </div>

        </div>


        <h3>Book Details</h3>

        <div class="form">

            <div>
                <label>Book Name</label>
                <input type="text"
                       name="bookname"
                       placeholder="Enter book name"
                       required>
            </div>

            <div>
                <label>Book ID</label>
                <input type="text"
                       name="bookid"
                       placeholder="Enter book ID"
                       required>
            </div>

            <div>
                <label>Author</label>
                <input type="text"
                       name="author"
                       placeholder="Enter author name"
                       required>
            </div>

            <div>
                <label>Department</label>
                <select name="department">
                    <option>Computer Science</option>
                    <option>Information Technology</option>
                    <option>Electronics</option>
                    <option>Mechanical</option>
                    <option>Civil</option>
                    <option>Other</option>
                </select>
            </div>

        </div>


        <h3>Issue Details</h3>

        <div class="form">

            <div>
                <label>Issue Date</label>
                <input type="date"
                       name="issuedate"
                       required>
            </div>

            <div>
                <label>Return Date</label>
                <input type="date"
                       name="returndate"
                       required>
            </div>

        </div>


        <div class="buttons">

            <input type="submit"
                   value="Register Book">

            <input type="reset"
                   value="Clear">

        </div>

    </form>


<%
    String student = request.getParameter("student");

    if (student != null) {

        String regno = request.getParameter("regno");
        String bookname = request.getParameter("bookname");
        String bookid = request.getParameter("bookid");
        String author = request.getParameter("author");
        String department = request.getParameter("department");
        String issuedate = request.getParameter("issuedate");
        String returndate = request.getParameter("returndate");
%>

    <hr>

    <h2 class="success">Book Issued Successfully!</h2>

    <table>

        <tr>
            <td>Student Name</td>
            <td><%= student %></td>
        </tr>

        <tr>
            <td>Register Number</td>
            <td><%= regno %></td>
        </tr>

        <tr>
            <td>Book Name</td>
            <td><%= bookname %></td>
        </tr>

        <tr>
            <td>Book ID</td>
            <td><%= bookid %></td>
        </tr>

        <tr>
            <td>Author</td>
            <td><%= author %></td>
        </tr>

        <tr>
            <td>Department</td>
            <td><%= department %></td>
        </tr>

        <tr>
            <td>Issue Date</td>
            <td><%= issuedate %></td>
        </tr>

        <tr>
            <td>Return Date</td>
            <td><%= returndate %></td>
        </tr>

    </table>

<%
    }
%>

</div>

</body>
</html>
