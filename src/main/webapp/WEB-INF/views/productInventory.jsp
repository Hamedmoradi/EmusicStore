<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/9/2020
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>PRODUCT INVENTORY PAGE</h1>
            <p class="lead">This is the product inventory page!</p>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>photo Thumb</th>
                <th>productName</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th></th>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image"
                    style="width:100% "></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice}</td>
                    <td><a href="<spring:url value="/productList/viewProduct/${product.productId}"/>">
                        <span class="glyphicon-info-sign "></span></a>
                    <a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId}"/>">
                        <span class="glyphicon-remove btn btn-primary"></span></a></td>
                    <td><a href="<spring:url value="/admin/productInventory/editProduct/${product.productId}"/>">
                        <span class="glyphicon-pencil btn btn-primary"></span></a></td>
                </tr>
            </c:forEach>
        </table>

        <a href="<c:url value="/admin/productInventory/addProduct"/>"
           class="btn btn-primary flex-grow-1 flex-lg-grow-0">Add Product</a>

<%@include file="/WEB-INF/views/template/footer.jsp" %>