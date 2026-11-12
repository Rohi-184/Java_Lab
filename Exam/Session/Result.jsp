<!DOCTYPE html>
<html>

<head>
    <title>Quiz Result</title>

    <style>
        body {
            font-family: Arial;
            background: #f2f6fc;
        }

        .result {
            width: 450px;
            margin: 80px auto;
            padding: 30px;
            background: white;
            text-align: center;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        h2 {
            color: #0146B3;
        }

        .score {
            font-size: 28px;
            font-weight: bold;
            margin: 15px;
        }

        .box {
            padding: 15px;
            margin-top: 15px;
            background: #f2f6fc;
            border-radius: 5px;
        }
    </style>
</head>

<body>

<div class="result">

    <h2>Quiz Completed</h2>

    <%
        Integer scoreValue = (Integer) session.getAttribute("score");
        if (scoreValue == null) {
            scoreValue = 0;
        }
    %>

    <!-- JAVA SESSION -->

    <div class="box">

        <h3>Java HttpSession</h3>

        <p>Score stored in Java Session:</p>

        <div class="score">
            <%= scoreValue %> / 3
        </div>

        <p>Session ID:</p>

        <p>
            <%= session.getId() %>
        </p>

    </div>
</div>


<script>

    let javaScore = <%= scoreValue %>;

    sessionStorage.setItem("score", javaScore);

    sessionStorage.setItem("total", "3");

    // Read score from Session Storage
    let score = sessionStorage.getItem("score");
    let total = sessionStorage.getItem("total");

</script>

</body>
</html>