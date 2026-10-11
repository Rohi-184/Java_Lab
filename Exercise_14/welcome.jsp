<%@ page import="jakarta.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome - Cookie Example</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #0146B3, #4f8de8);
            min-height: 100vh;

            display: flex;
            justify-content: center;
            align-items: center;
        }

        .welcome-container {
            width: 420px;
            background: white;
            padding: 40px;
            border-radius: 15px;
            text-align: center;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.20);
        }

        .success-icon {
            width: 65px;
            height: 65px;
            margin: 0 auto 20px;

            display: flex;
            justify-content: center;
            align-items: center;

            background: #e8f7ee;
            color: #20a05a;

            border-radius: 50%;

            font-size: 32px;
            font-weight: bold;
        }

        .welcome-container h2 {
            margin: 0 0 10px;
            color: #0146B3;
        }

        .welcome-message {
            color: #444;
            font-size: 16px;
            margin-bottom: 10px;
        }

        .cookie-message {
            background: #f2f6fc;
            border-left: 4px solid #0146B3;
            padding: 12px;
            margin: 20px 0;
            color: #555;
            font-size: 14px;
            text-align: left;
            border-radius: 5px;
        }

        .username {
            color: #0146B3;
            font-weight: bold;
        }

        .back-btn {
            display: inline-block;
            padding: 12px 25px;

            background: #0146B3;
            color: white;

            text-decoration: none;
            border-radius: 8px;

            font-size: 14px;
            font-weight: bold;
        }

        .back-btn:hover {
            background: #00398f;
        }

        .footer {
            margin-top: 25px;
            font-size: 12px;
            color: #999;
        }
    </style>
</head>

<body>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String remember = request.getParameter("remember");
%>

<div class="welcome-container">

<%
    if ("admin".equals(username) && "1234".equals(password)) {

        if (remember != null) {

            Cookie userCookie =
                new Cookie("username", username);

            // Cookie valid for 7 days
            userCookie.setMaxAge(7 * 24 * 60 * 60);

            response.addCookie(userCookie);
        }
%>
    <h2>Login Successful</h2>

    <p class="welcome-message">
        Welcome,
        <span class="username">
            <%= username %>
        </span>
    </p>

    <div class="cookie-message">
        Your username has been saved in a cookie
        for 7 days.
    </div>

    <a href="login.jsp" class="back-btn">
        Back to Login
    </a>

<%
    } else {
%>
    <h2 style="color:#d93025;">
        Login Failed
    </h2>

    <p class="welcome-message">
        Invalid username or password.
    </p>

    <br>

    <a href="login.jsp" class="back-btn">
        Try Again
    </a>

<%
    }
%>

</div>

</body>
</html>