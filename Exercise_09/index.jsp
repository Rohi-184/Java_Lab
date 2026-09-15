<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Library Book Issue</title>

    <style>
* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
}

body {
    background: #eef2ff;
    padding: 30px 20px;
    color: #1f2937;
}

.container {
    max-width: 1100px;
    margin: auto;
}

.header {
    background: linear-gradient(135deg, #4338ca, #7c3aed);
    color: white;
    padding: 25px 30px;
    border-radius: 14px;
    margin-bottom: 20px;
}

.header h1 {
    font-size: 28px;
    margin-bottom: 5px;
}

.header p {
    font-size: 14px;
    color: #e0e7ff;
}

.content {
    display: grid;
    grid-template-columns: 1.3fr 1fr;
    gap: 20px;
}

.card {
    background: white;
    padding: 25px;
    border-radius: 14px;
    box-shadow: 0 5px 18px #0001;
}

.section-title {
    color: #4338ca;
    font-weight: bold;
    font-size: 17px;
    margin-bottom: 15px;
    padding-bottom: 8px;
    border-bottom: 2px solid #eef2ff;
}

.form-grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 15px;
    margin-bottom: 22px;
}

.form-group {
    display: flex;
    flex-direction: column;
}

label {
    font-size: 13px;
    font-weight: bold;
    margin-bottom: 6px;
}

input, select {
    padding: 11px;
    border: 1px solid #d1d5db;
    border-radius: 7px;
    background: #f9fafb;
    outline: none;
}

input:focus, select:focus {
    border-color: #6366f1;
}

.buttons {
    display: flex;
    gap: 10px;
}

.btn {
    padding: 12px 20px;
    border: 0;
    border-radius: 7px;
    font-weight: bold;
    cursor: pointer;
}

.register-btn {
    flex: 1;
    background: #4f46e5;
    color: white;
}

.clear-btn {
    background: #e5e7eb;
    color: #374151;
}

/* Ready Message */

.ready {
    text-align: center;
    padding: 35px 15px;
}

.ready-icon {
    font-size: 50px;
    margin-bottom: 15px;
}

.ready h2 {
    color: #4338ca;
    margin-bottom: 10px;
}

.ready p {
    color: #6b7280;
    font-size: 14px;
    line-height: 1.5;
}

.info-box {
    margin-top: 20px;
    padding: 15px;
    background: #f5f7ff;
    border-radius: 8px;
    text-align: left;
    font-size: 13px;
}

/* Success */

.success {
    text-align: center;
}

.tick {
    width: 65px;
    height: 65px;
    margin: 5px auto 15px;
    border-radius: 50%;
    background: #10b981;
    color: white;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 38px;
    font-weight: bold;
}

.success h2 {
    color: #047857;
    margin-bottom: 6px;
}

.success > p {
    color: #065f46;
    font-size: 13px;
    margin-bottom: 18px;
}

.details {
    border: 1px solid #d1fae5;
    border-radius: 8px;
    overflow: hidden;
}

.details table {
    width: 100%;
    border-collapse: collapse;
}

.details td {
    padding: 10px;
    font-size: 13px;
    border-bottom: 1px solid #eee;
}

.details td:first-child {
    width: 40%;
    background: #f0fdf4;
    font-weight: bold;
}

.date {
    color: #047857;
    font-weight: bold;
}

    </style>
</head>

<body>

<div class="container">

    <!-- Header -->

    <div class="header">
        <h1>📚 Library Book Issue</h1>
        <p>Register a book borrowed from the library</p>
    </div>


    <!-- TWO COLUMN LAYOUT -->

    <div class="content">

        <!-- LEFT : FORM -->

        <div class="card">

            <form method="post">

                <!-- Student -->

                <div class="section-title">
                    <div class="section-icon">👤</div>
                    Student Details
                </div>

                <div class="form-grid">

                    <div class="form-group">
                        <label>Student Name</label>
                        <input type="text"
                               name="student"
                               placeholder="Enter your name"
                               required>
                    </div>

                    <div class="form-group">
                        <label>Register Number</label>
                        <input type="text"
                               name="regno"
                               placeholder="Enter register number"
                               required>
                    </div>

                </div>


                <!-- Book -->

                <div class="section-title">
                    <div class="section-icon">📖</div>
                    Book Details
                </div>

                <div class="form-grid">

                    <div class="form-group">
                        <label>Book Name</label>
                        <input type="text"
                               name="bookname"
                               placeholder="Enter book name"
                               required>
                    </div>

                    <div class="form-group">
                        <label>Book ID</label>
                        <input type="text"
                               name="bookid"
                               placeholder="Enter book ID"
                               required>
                    </div>

                    <div class="form-group">
                        <label>Author</label>
                        <input type="text"
                               name="author"
                               placeholder="Enter author name"
                               required>
                    </div>

                    <div class="form-group">
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


                <!-- Issue -->

                <div class="section-title">
                    <div class="section-icon">📅</div>
                    Issue Details
                </div>

                <div class="form-grid">

                    <div class="form-group">
                        <label>Issue Date</label>
                        <input type="date"
                               name="issuedate"
                               required>
                    </div>

                    <div class="form-group">
                        <label>Return Date</label>
                        <input type="date"
                               name="returndate"
                               required>
                    </div>

                </div>


                <!-- Buttons -->

                <div class="buttons">

                    <input type="submit"
                           value="✓  Register Book Issue"
                           class="btn register-btn">

                    <input type="reset"
                           value="Clear"
                           class="btn clear-btn">

                </div>

            </form>

        </div>


        <!-- RIGHT : RESULT -->

        <div class="card">

<%
String student = request.getParameter("student");

if (student == null) {
%>

            <!-- Before Registration -->

            <div class="ready">

                <div class="ready-icon">
                    📚
                </div>

                <h2>Ready to Issue</h2>

                <p>
                    Enter your student and book details
                    on the left to register the book you
                    have borrowed.
                </p>

                <div class="info-box">
                    <strong>Library Notice</strong><br><br>
                    Please make sure the Book ID and
                    return date are correct before
                    registering the book.
                </div>

            </div>

<%
} else {

    String regno = request.getParameter("regno");
    String bookname = request.getParameter("bookname");
    String bookid = request.getParameter("bookid");
    String author = request.getParameter("author");
    String department = request.getParameter("department");
    String issuedate = request.getParameter("issuedate");
    String returndate = request.getParameter("returndate");
%>

            <!-- After Registration -->

            <div class="success">

                <div class="tick">
                    ✓
                </div>

                <h2>Book Issued Successfully!</h2>

                <p>
                    The book has been registered successfully.
                </p>


                <div class="details">

                    <table>

                        <tr>
                            <td>Student Name</td>
                            <td><%= student %></td>
                        </tr>

                        <tr>
                            <td>Register No.</td>
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
                            <td class="date"><%= issuedate %></td>
                        </tr>

                        <tr>
                            <td>Return Date</td>
                            <td class="date"><%= returndate %></td>
                        </tr>

                    </table>

                </div>

            </div>

<%
}
%>

        </div>

    </div>

</div>

</body>
</html>
```
