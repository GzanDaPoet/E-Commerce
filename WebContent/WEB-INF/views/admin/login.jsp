<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin | Login</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@100;300;400;500;600;700;800&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/reset.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/admin/login.css' />">
</head>
<body>
	<div class="login">
		<div class="login__image">
			<div class="login__logo">
				<img src="<c:url value ='/common/images/logo.png'/>" alt="">
			</div>
			<h3>Hi, Welcome back!</h3>
			<img
				src="<c:url value ='/common/images/illustration_dashboard.svg'/>"
				alt="">
		</div>
		<div class="login__form">
			<form action="">
				<div class="login__form-group">
					<div class="group-header">
						<h3>Sign up to E-commerce</h3>
						<span>New user? <a href="#">Create an account</a></span>
					</div>
					<div class="input-container">
						<input type="text" required="required" id="username"
							name="username" aria-labelledby="username"><span
							class="highlight"></span><span class="bar"></span> <label
							for="searchText">User name</label>
					</div>
					<div class="input-container">
						<input type="password" required="required" id="password"
							name="password" aria-labelledby="password"><span
							class="highlight"></span><span class="bar"></span> <label
							for="searchText">Password</label>
					</div>
					<div class="form-submit">
						<a href="#">Forgot password?</a>
						<button>Login</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>