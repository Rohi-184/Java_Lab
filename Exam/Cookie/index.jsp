<%@ page import="jakarta.servlet.http.Cookie" %>

<html>
<body>

<h2>Cookie Management</h2>

<%
    Cookie cookie = new Cookie("username", "Rohith");

    // Cookie will expire after 05 seconds
    cookie.setMaxAge(05);

    response.addCookie(cookie);
%>

<p>Cookie created successfully!</p>
<p>Username: Rohith</p>
<p>Cookie expires after 05 seconds.</p>

<br>

<a href="readCookie.jsp">Read Cookie</a>

</body>
</html>