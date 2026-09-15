<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
String url = "jdbc:mysql://localhost:3306/librarydb";
String user = "root";
String pass = "";
String action = request.getParameter("action");
String msg = "";

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, user, pass);

    if ("insert".equals(action)) {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO books(title,author,category,quantity,price) VALUES(?,?,?,?,?)"
        );
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setString(3, category);
        ps.setInt(4, quantity);
        ps.setDouble(5, price);
        ps.executeUpdate();
        ps.close();

        response.sendRedirect("index.jsp?action=view&msg=Book added successfully");
        return;
    }

    if ("update".equals(action)) {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String category = request.getParameter("category");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        PreparedStatement ps = con.prepareStatement(
            "UPDATE books SET title=?,author=?,category=?,quantity=?,price=? WHERE id=?"
        );
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setString(3, category);
        ps.setInt(4, quantity);
        ps.setDouble(5, price);
        ps.setInt(6, id);
        ps.executeUpdate();
        ps.close();

        response.sendRedirect("index.jsp?action=view&msg=Book updated successfully");
        return;
    }

    if ("delete".equals(action)) {
        int id = Integer.parseInt(request.getParameter("id"));

        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM books WHERE id=?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();

        response.sendRedirect("index.jsp?action=view&msg=Book deleted successfully");
        return;
    }

    con.close();
} catch (Exception e) {
    msg = "Error: " + e.getMessage();
}

if (request.getParameter("msg") != null) {
    msg = request.getParameter("msg");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Management System</title>
<style>
* {
    box-sizing: border-box;
}
body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: #f2f5f7;
}
.container {
    width: 950px;
    margin: 40px auto;
    background: white;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 15px #ccc;
}
h1 {
    text-align: center;
    color: #234e70;
    margin-bottom: 5px;
}
.subtitle {
    text-align: center;
    color: #666;
    margin-bottom: 25px;
}
.menu {
    display: flex;
    justify-content: center;
    gap: 10px;
    margin-bottom: 25px;
}
.menu a {
    text-decoration: none;
    background: #234e70;
    color: white;
    padding: 10px 18px;
    border-radius: 5px;
}
.menu a:hover {
    background: #173852;
}
.message {
    text-align: center;
    padding: 10px;
    margin-bottom: 20px;
    background: #e8f5e9;
    color: #256029;
    border-radius: 5px;
}
.form-box {
    width: 450px;
    margin: auto;
}
label {
    display: block;
    margin-top: 12px;
    font-weight: bold;
}
input {
    width: 100%;
    padding: 8px;
    margin-top: 5px;
    border: 1px solid #bbb;
    border-radius: 4px;
}
input[type="submit"] {
    background: #234e70;
    color: white;
    border: 0;
    cursor: pointer;
    margin-top: 15px;
}
table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 15px;
}
th {
    background: #234e70;
    color: white;
    padding: 10px;
}
td {
    border: 1px solid #ccc;
    padding: 7px;
    text-align: center;
}
td input {
    margin: 0;
    padding: 6px;
}
.save {
    background: #287a3e !important;
    width: auto !important;
    padding: 7px 12px !important;
    margin: 0 !important;
}
.delete {
    background: #b42318 !important;
    width: auto !important;
    padding: 7px 12px !important;
    margin: 5px 0 0 !important;
}
.home {
    text-align: center;
    padding: 30px;
}
</style>
</head>
<body>
<div class="container">
<h1>Library Management System</h1>
<div class="subtitle">Manage Library Books</div>

<div class="menu">
<a href="index.jsp">Home</a>
<a href="index.jsp?action=add">Add Book</a>
<a href="index.jsp?action=view">View / Edit Books</a>
</div>

<% if (!msg.equals("")) { %>
<div class="message"><%= msg %></div>
<% } %>

<% if (action == null) { %>
<div class="home">
<h2>Welcome</h2>
<p>Select an option above to manage library books.</p>
</div>
<% } %>

<% if ("add".equals(action)) { %>
<div class="form-box">
<h2>Add New Book</h2>
<form method="post" action="index.jsp">
<input type="hidden" name="action" value="insert">

<label>Book Title</label>
<input type="text" name="title" required>

<label>Author</label>
<input type="text" name="author" required>

<label>Category</label>
<input type="text" name="category" required>

<label>Quantity</label>
<input type="number" name="quantity" min="0" required>

<label>Price</label>
<input type="number" name="price" min="0" step="0.01" required>

<input type="submit" value="Add Book">
</form>
</div>
<% } %>

<% if ("view".equals(action)) { %>
<h2>Library Books</h2>
<table>
<tr>
<th>ID</th>
<th>Title</th>
<th>Author</th>
<th>Category</th>
<th>Quantity</th>
<th>Price</th>
<th>Action</th>
</tr>

<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, user, pass);
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM books");

    while (rs.next()) {
%>

<tr>
<td><%= rs.getInt("id") %></td>

<td>
<form method="post" action="index.jsp">
<input type="hidden" name="action" value="update">
<input type="hidden" name="id" value="<%= rs.getInt("id") %>">
<input type="text" name="title" value="<%= rs.getString("title") %>" required>
</td>

<td>
<input type="text" name="author" value="<%= rs.getString("author") %>" required>
</td>

<td>
<input type="text" name="category" value="<%= rs.getString("category") %>" required>
</td>

<td>
<input type="number" name="quantity" value="<%= rs.getInt("quantity") %>" min="0" required>
</td>

<td>
&#8377;<input type="number" name="price" value="<%= rs.getDouble("price") %>" step="0.01" min="0" required style="width:80px">
</td>

<td>
<input type="submit" value="Save" class="save">
</form>

<form method="post" action="index.jsp">
<input type="hidden" name="action" value="delete">
<input type="hidden" name="id" value="<%= rs.getInt("id") %>">
<input type="submit" value="Delete" class="delete" onclick="return confirm('Are you sure you want to delete this book?');">
</form>
</td>
</tr>

<%
    }
    rs.close();
    st.close();
    con.close();
} catch (Exception e) {
    out.println("<tr><td colspan='7'>Error: " + e.getMessage() + "</td></tr>");
}
%>
</table>
<% } %>

</div>
</body>
</html>