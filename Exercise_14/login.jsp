<%@ page import="jakarta.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login - Cookie Example</title>

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

        .login-container {
            width: 380px;
            background: white;
            padding: 35px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.20);
        }

        .login-container h2 {
            text-align: center;
            color: #0146B3;
            margin-bottom: 8px;
        }

        .subtitle {
            text-align: center;
            color: #777;
            font-size: 14px;
            margin-bottom: 28px;
        }

        .form-group {
            margin-bottom: 18px;
        }

        .form-group label {
            display: block;
            margin-bottom: 7px;
            color: #333;
            font-size: 14px;
            font-weight: bold;
        }

        .form-group input[type="text"],
        .form-group input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            outline: none;
        }

        .form-group input[type="text"]:focus,
        .form-group input[type="password"]:focus {
            border-color: #0146B3;
            box-shadow: 0 0 0 3px rgba(1, 70, 179, 0.10);
        }

        .remember {
            display: flex;
            align-items: center;
            gap: 8px;
            margin-bottom: 22px;
            font-size: 14px;
            color: #555;
        }

        .remember input {
            width: 16px;
            height: 16px;
            accent-color: #0146B3;
        }

        .login-btn {
            width: 100%;
            padding: 13px;
            background: #0146B3;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
        }

        .login-btn:hover {
            background: #00398f;
        }

        .footer {
            text-align: center;
            margin-top: 20px;
            font-size: 12px;
            color: #999;
        }
    </style>
</head>

<body>

<%
    String savedUsername = "";

    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                savedUsername = cookie.getValue();
            }
        }
    }
%>

<div class="login-container">

    <h2>Welcome Back</h2>

    <p class="subtitle">
        Login to continue
    </p>

    <form action="welcome.jsp" method="post">

        <div class="form-group">
            <label>Username</label>

            <input type="text"
                   name="username"
                   value="<%= savedUsername %>"
                   placeholder="Enter your username"
                   required>
        </div>

        <div class="form-group">
            <label>Password</label>

            <input type="password"
                   name="password"
                   placeholder="Enter your password"
                   required>
        </div>

        <div class="remember">

            <input type="checkbox"
                   name="remember"
                   id="remember">

            <label for="remember">
                Remember Me
            </label>

        </div>

        <button type="submit" class="login-btn">
            Login
        </button>

    </form>

</div>

</body>
</html>