<%--
  Created by IntelliJ IDEA.
  User: Admind
  Date: 28/12/2021
  Time: 2:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1>My First Bootstrap 4 Page</h1>
    <p>Resize this responsive page to see the effect!</p>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/login">dang xuat</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">userManagement : vinh
                    </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-6">
            <h2>product</h2>
            <table class="table table-striped">
                <thead>
                <tbody>
                <c:forEach items="${products}" var="p" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${p.name}</td>
                        <td>${p.price}</td>
                        <td><img src="${p.img}" width="200" height="150" alt=""></td>

                        <td><a href="/product?action=edit&id=${p.getId()}" class="btn btn-success">edit</a></td>
                        <td><a href="/product?action=delete&id=${p.id}" class="btn btn-danger">delete</a></td>
                        <td> <a href="/product?action=create&id=${p.id}" class="btn btn-success">create</a></td>

                    </tr>\
                </c:forEach>
                </tbody>
                </thead>


            </table>
            <h1> user name</h1>
            <%= request.getParameter("username") %>>


        </div>
    </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>

</body>
</html>