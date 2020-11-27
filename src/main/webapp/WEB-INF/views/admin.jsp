<%--
  Created by IntelliJ IDEA.
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/27/2020
  Time: 11:19 PM
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
            <h1>ADMINISTRATOR PAGE</h1>
            <p class="lead">this is the administrator page.</p>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name!=null}">
        <h2>
            Welcome:${pageContext.request.userPrincipal.name} | <a href="<c:url value="/login?logout"/>">
            LogOut</a>
        </h2>
        </c:if>

        <h3>
            <a href="<c:url value="/admin/productInventory" />" > Product Inventory </a>
        </h3>
        <p>Here you can view,check and modify the product inventory!</p>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
