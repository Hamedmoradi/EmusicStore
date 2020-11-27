<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/9/2020
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div id="login-box">
            <h2>Login with Username and Password</h2>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
			<form name="loginForm" action="<c:url value="/login"/>" method="post">
			<div class="form-group">
				<label for="username">User:</label>
				<c:if test="${not empty error}">
				<div class="error" style="color:#ff0000">${error}</div>
			</c:if>

				<input type="text" id="username" name="username" class="form-control">
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="text" id="password" name="password" class="form-control">
			</div>
			<input type="submit" value="submit" class="btn btn-default">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
			</form>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>