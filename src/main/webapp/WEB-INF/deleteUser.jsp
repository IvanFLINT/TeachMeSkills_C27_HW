
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lesson_41</title>
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
            <h1>Введите id пользователя</h1>
            <form action="delete" method="post">
                <div class="mb-3">
                    <label for="id" class="form-label">ID</label>
                    <input type="text" class="form-control" id="id" name="id" aria-describedby="emailHelp">
                </div>
                <button class="btn btn-primary" type="submit">Delete</button>
                <a class="btn btn-primary" href="/index" role="button">Главная</a>
            </form>
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
