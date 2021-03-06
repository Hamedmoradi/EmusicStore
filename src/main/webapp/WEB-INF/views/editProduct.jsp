<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 11/19/2020
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container-wrapper">
    <div class="container"/>
    <div class="page-header"/>
    <h1>EDIT PRODUCT</h1>
    <p class="lead">Fill the below information to edit a product:</p>
</div>
<form:form action="${pagecontext.request.contextpath}/admin/productInventory/editProduct" method="post"
           modelAttribute="product" enctype="multipart/form-data">
    <form:hidden path="productId" value="${product.productId}"/>
    <div class="form-group">
        <label for="name">Name</label>
        <form:input path="productName" id="name" class="form-Control" value="${product.productName}"/>
    </div>
    <div class="form-group">
        <label for="category">category</label>
        <label class="checkbox-inline">
            <form:radiobutton path="productCategory" id="category" value="instrumental"/>Instrumental</label>
        <form:radiobutton path="productCategory" id="category" value="record "/>Record</label>
        <form:radiobutton path="productCategory" id="category" value="accessory "/>Accessory</label>
        </label>
    </div>
    <div class="form-group">
        <label for="description">Description</label>
        <form:textarea path="productDescription" id="description" class="form-Control" value="${product.productDescription}"/>
    </div>
    <div class="form-group">
        <label for="condition">Condition</label>
        <label class="checkbox-inline">
            <form:radiobutton path="productCondition" id="condition" value="new "/>New</label>
        <form:radiobutton path="productCondition" id="condition" value="used "/>Used</label>
        </label>
    </div>
    <div class="form-group">
        <label for="status">Status</label>
        <label class="checkbox-inline">
            <form:radiobutton path="productStatus" id="status" value="active "/>Active</label>
        <form:radiobutton path="productStatus" id="status" value="inactive "/>Inactive</label>
        </label>
    </div>
    <div class="form-group">
        <label for="unitInStock">Unit In Stock</label>
        <form:input path="unitInStock" id="unitInStock" class="form-Control" value="${product.unitInStock}"/>
    </div>
    <div class="form-group">
        <label for="manufacturer">Manufacturer</label>
        <form:input path="productManufacturer" id="manufacturer" class="form-Control" value="${product.productManufacturer}"/>
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <form:input path="productPrice" id="price" class="form-Control" value="${product.productPrice}"/>
    </div>
    <div class="form-group">
        <label class="control-label" for="productImage">Upload Picture</label>
        <form:input  id="productImage" path="productImage" type="file" class="form:input-large"/>
    </div>
    <br><br>
    <input type="submit" value="submit" class="btn btn-default">
    <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancle</a>
    </div>
</form:form>

<%@include file="/WEB-INF/views/template/footer.jsp" %>