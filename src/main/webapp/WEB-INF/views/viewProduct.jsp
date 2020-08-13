<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 8/8/2020
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>PRODUCT DETAILS</h1>
            <p class="lead">here is a information of the product</p>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-5">
                    <img src="#" alt="image" style="width:100% ;height:300px"/>
                </div>
                <div class="col-lg-5">
                    <h3><img src="#" alt="image"></h3>
                    <p>${product.productName}</p>
                    <p>${product.productCategory}</p>
                    <p>${product.productCondition}</p>
                    <h4>${product.productPrice}</h4>
                </div>
            </div>
        </div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>