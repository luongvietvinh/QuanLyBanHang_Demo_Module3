<%--
  Created by IntelliJ IDEA.
  User: Admind
  Date: 29/12/2021
  Time: 5:35 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<form method="post">
    <div class="form-group">
        <label >nhap name</label>
        <input type="text" class="form-control" name="name" aria-describedby="emailHelp" placeholder="enter name">
    </div>
    <div class="form-group">
        <label>nhap img</label>
        <input type="text" class="form-control" name="img" aria-describedby="emailHelp" placeholder="enter img">
    </div>
    <div class="form-group">
        <label >price</label>
        <input type="text" class="form-control" name="price" placeholder="enter price">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
