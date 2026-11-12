<%
    if ("POST".equals(request.getMethod())) {

        int score = 0;

        String q1 = request.getParameter("q1");
        String q2 = request.getParameter("q2");
        String q3 = request.getParameter("q3");

        if ("Java".equals(q1))
            score++;

        if ("HttpSession".equals(q2))
            score++;

        if ("invalidate".equals(q3))
            score++;

        // JAVA SESSION
        session.setAttribute("score", score);

        // Send score to Result.jsp
        request.setAttribute("score", score);

        request.getRequestDispatcher("Result.jsp")
               .forward(request, response);

        return;
    }
%>

<!DOCTYPE html>
<html>

<head>
    <title>Java Quiz</title>

    <style>
        body {
            font-family: Arial;
            background: #f2f6fc;
        }

        .quiz {
            width: 500px;
            margin: 50px auto;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        h2 {
            text-align: center;
            color: #0146B3;
        }

        input[type="submit"] {
            background: #0146B3;
            color: white;
            padding: 10px 25px;
            border: none;
            border-radius: 5px;
        }
    </style>
</head>

<body>

<div class="quiz">

    <h2>Java Servlet Quiz</h2>

    <form method="post">

        <p><b>1. Which language is used for Servlet?</b></p>

        <input type="radio" name="q1" value="Java" required> Java<br>
        <input type="radio" name="q1" value="Python"> Python<br>
        <input type="radio" name="q1" value="C"> C<br>


        <p><b>2. Which object is used for session management?</b></p>

        <input type="radio" name="q2" value="HttpSession" required>
        HttpSession<br>

        <input type="radio" name="q2" value="Cookie">
        Cookie<br>

        <input type="radio" name="q2" value="Request">
        Request<br>


        <p><b>3. Which method is used to end a session?</b></p>

        <input type="radio" name="q3" value="invalidate" required>
        invalidate()<br>

        <input type="radio" name="q3" value="close">
        close()<br>

        <input type="radio" name="q3" value="destroy">
        destroy()<br>

        <br>

        <input type="submit" value="Submit Quiz">

    </form>

</div>

</body>
</html>