<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lesson_30</title>
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
            <h1>Введите данные заявки</h1>
            <form action="request" method="post">
                 <div class="mb-3">
                     <label for="name" class="form-label">Name</label>
                     <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp">
                 </div>
                 <div class="mb-3">
                     <label for="email" class="form-label">Email address</label>
                     <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
                 </div>
                 <div class="mb-3">
                     <label for="password" class="form-label">Password</label>
                     <input type="password" class="form-control" id="password" name="password">
                 </div>
                 <button type="submit" class="btn btn-primary" >Send</button>
             </form>
        </div>
    </div>
</div>
</body>
</html>
