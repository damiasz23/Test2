<%@ page import="carRent.rent.CarRepository" %>
<%@ page import="carRent.rent.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="carRent.rent.RentRepository" %>
<%@ page import="carRent.rent.Rent" %>
<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
   HashMap<String, String> error = (HashMap<String, String>)request.getAttribute("error");
   if(error!=null && error.equals("true"))
       pageContext.setAttribute("error", error);

%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Item - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-item.css" rel="stylesheet">

</head>

<body>

<!-- Page Content -->
<div class="container">

            <div class="card card-container">
                <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
                <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
                <p id="profile-name" class="profile-name-card"></p>
                <a href="#" class="forgot-password">
                    Forgot the password?
                </a>
                <form class="form-signin" action="/register" method="post">
                    <span id="reauth-email" class="reauth-email"></span>
                    <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Email address" required autofocus>
                    <p>${error.get("email")}</p>
                    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
                    <p>${error.get("password")}</p>
                    <input type="password" id="inputPassword2" name="passwordRepeat" class="form-control" placeholder="Password repeat" required>
                    <p>${error.get("passwordRepeat")}</p>
                    <input type="text" id="firstName" name="firstName" class="form-control" placeholder="First name" required>
                    <p>${error.get("firstName")}</p>
                    <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Lastname" required>
                    <p>${error.get("lastName")}</p>phoneNumber
                    <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" placeholder="Phone number" required>
                    <p>${error.get("phoneNumber")}</p>
                    <label>Day if birth</label>
                    <input type="date" id="dayOfBirth" name="dayOfBirth" class="form-control">
                    <p>${error.get("dayOfBirth")}</p>
                    <label>Licence car day</label>
                    <input type="date" id="licenceCarDay" name="licenceCarDay" class="form-control">
                    <p>${error.get("licenceCarDay")}</p>

                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign up</button>


                </form><!-- /form -->
            </div>
        </div>
<jsp:include page="footer.jsp"/>