<%@ page import="jakarta.servlet.http.Cookie" %>

<html>
<body>

<h2>Read Cookie</h2>

<%
    Cookie[] cookies = request.getCookies();

    boolean found = false;

    if (cookies != null) {

        for (Cookie c : cookies) {

            if (c.getName().equals("username")) {

                out.println("<p>Username: " + c.getValue() + "</p>");
                found = true;
            }
        }
    }

    if (!found) {
        out.println("<p>Cookie not found or expired.</p>");
    }
%>

</body>
</html>