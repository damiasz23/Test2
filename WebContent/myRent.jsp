<%@ page import="carRent.rent.CarRepository" %>
<%@ page import="carRent.rent.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="carRent.rent.RentRepository" %>
<%@ page import="carRent.rent.Rent" %>
<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<Rent> rentList = RentRepository.findByUserId(15);
    pageContext.setAttribute("rentList", rentList);
%>
<jsp:include page="header.jsp"/>

<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">
            <h1 class="my-4">DamRent</h1>
            <div class="list-group">
                <a href="#" class="list-group-item active">Category 1</a>
                <a href="#" class="list-group-item">Category 2</a>
                <a href="#" class="list-group-item">Category 3</a>
            </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">
            <c:forEach items="${rentList}" var="rent">
            <div class="row">
                <table>
                <div class="col-md-2">
                    <p>${rent.car.model}</p>
                </div>
                <div class="col-md-2">
                    <p>${rent.car.basePrice}</p>
                </div>

                <div class="col-md-2">
                    <p>${rent.startDate}</p>
                    </divc>
                    <div class="col-md-2">
                        <p>${rent.endDate}</p>
                        </divc>
                        <div class="col-md-2">
                            <p>${rent.rentPrice}</p>
                            </divc>

                            <div class="col-md-2">

                                </divc>
                                <div class="col-md-2">
                                    <a href="/details.jsp?carId=${rent.car.id}" class="btn btn-primary">Zobacz szczegóły</a>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                        <!-- /.col-lg-9 -->


                    </div>
                </div>
                </table>
                <!-- /.container -->
            </div>
                <jsp:include page="footer.jsp"/>