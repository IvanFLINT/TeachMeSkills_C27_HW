
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lesson_35</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <style>
        body {
            background: darkgrey;
        }

        .col-12 {
            margin: 20% 10% 0 10%;
            width: 60%;
        }
    </style>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <h1>Выбирите опперацию:</h1>
            <a class="btn btn-primary" href="/create" role="button">Создать пользователя</a>
            <a class="btn btn-primary" href="/delete" role="button">Удалить пользователя по ID</a>
            <a class="btn btn-primary" href="/get" role="button">Получить информацию по ID</a>
            <a class="btn btn-primary" href="/change-login" role="button">Изменить логин по ID</a>
        </div>
    </div>
</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
