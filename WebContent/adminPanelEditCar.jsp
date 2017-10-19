<%@ page import="carRent.rent.CarRepository" %>
<%@ page import="carRent.rent.Car" %>
<%@ page import="carRent.rent.CarSegment" %>
<%@ page import="carRent.rent.Make" %>
<%@ page import="carRent.rent.Color" %>
<%@ page import="carRent.rent.EngineType" %>
<%@ page import="carRent.rent.GearBox" %>
<%@ page import="java.util.Optional" %>
<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String carId = request.getParameter("carId");
    Integer id = null;
    try {
        id = Integer.valueOf(carId);
    }catch (Exception ex){
        ex.printStackTrace();
    }
    if(id!=null) {
        Optional<Car> car = CarRepository.findCar(id);
        if (car.isPresent())
            pageContext.setAttribute("car", car.get());
    }
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

                <form class="form-signin" action="/editCar" method="post">
                    <input type="hidden" value="${car.id}" id="id" name="id" class="form-control">

                    <input type="text" value="${car.model}" id="model" name="model" class="form-control" placeholder="Car model" required autofocus>

                    <input type="number" value="${car.insuranceCost}" id="insuranceCost" name="insuranceCost" class="form-control" placeholder="Car insurance cost" required autofocus>

                    <input type="number" value="${car.capasity}" id="capasity" name="capasity" class="form-control" placeholder="Car capasity" required autofocus>

                    <input type="number" value="${car.basePrice}" id="basePrice" name="basePrice" class="form-control" placeholder="Car base price" required autofocus>

                    <select class="form-control" name="segment">
                    <c:forEach var="segment" items="${CarSegment.values()}"><option value="${segment}">${segment}</option>
                    </c:forEach>
                    </select>


                    <select class="form-control" name="make">
                        <c:forEach var="make" items="${Make.values()}"><option value="${make}">${make}</option>
                        </c:forEach>
                    </select>

                    <select class="form-control" name="color">
                        <c:forEach var="color" items="${Color.values()}"><option value="${color}">${color}</option>
                        </c:forEach>
                    </select>

                    <select class="form-control" name="engineType">
                        <c:forEach var="engineType" items="${EngineType.values()}"><option value="${engineType}">${engineType}</option>
                        </c:forEach>
                    </select>

                    <select class="form-control" name="gearBox">
                        <c:forEach var="gearBox" items="${GearBox.values()}"><option value="${gearBox}">${gearBox}</option>
                        </c:forEach>
                    </select>

                    <input type="number" value="${car.engine.torqe}" id="torqe" name="torqe" class="form-control" placeholder="Car engine torqe" required autofocus>
                    <input type="number" value="${car.engine.horsePower}" id="horsePower" name="horsePower" class="form-control" placeholder="Car engine horsePower" required autofocus>
                    <input type="number" value="${car.engine.fuealCompsution}" id="fuealCompsution" name="fuealCompsution" class="form-control" placeholder="Car engine fueal compsution" required autofocus>
                    <input type="number" value="${car.engine.engineCapasity}" id="engineCapasity" name="engineCapasity" class="form-control" placeholder="Car engine engine capasity" required autofocus>
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign up</button>
                </form><!-- /form -->
            </div>
        </div>
</div>
<jsp:include page="footer.jsp"/>