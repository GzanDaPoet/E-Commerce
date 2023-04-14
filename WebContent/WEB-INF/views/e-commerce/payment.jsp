<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Check Out</title>
<script src="https://kit.fontawesome.com/dbd4881242.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="/common/assets/css/cart/cart.css">
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<h2 class="col-sm-12 title">Check Out</h2>
			<ul class="col-sm-12 breadscrum-custom">
				<li class="breadscrum-custom-item"><a href="http://">Dashboard</a>
				</li>
				<li class="breadscrum-custom-item"><span class="dotted"></span>
					<a href="http://">E-Commerce</a></li>
				<li class="breadscrum-custom-item"><span class="dotted">
				</span> Check Out</li>
			</ul>
		</div>
		<div class="row">
			<ul class="col-xl-2 breadscrum-custom">
				<li class="breadscrum-custom-item"><a
					href="http://localhost:8080/com.ecommerce/e-commerce/cart.htm">Cart</a></li>
				<li class="breadscrum-custom-item"><span class="dotted"></span>
					<a
					href="http://localhost:8080/com.ecommerce/e-commerce/address.htm">Address
				</a></li>
				<li class="breadscrum-custom-item"><span class="dotted"></span>
					<p>Payment</p></li>
			</ul>
		</div>
		<form action="../checkout.htm" method="post">
			<div class="form-group">
				<div>
					<h3 class="col-xl-1 col-md title">Payment</h3>
				</div>
				<c:forEach var="i" items="${payment}">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="PaymentMethod"
							id="${i.id }" value="${i.id }">
						<label class="form-check-label" for="${i.id }"> ${i.paymentType.status }  Ngày hết hạn: ${ i.expiry } VND</label>
					</div>
				</c:forEach>
			</div>
			<div class="form-group">
				
				<div>
					<h3 class="col-xl-1 col-md title">Shipping</h3>
				</div>
				<c:forEach var="q" items="${shipping}">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="ShippingMethod"
							id="${q.id }" value="${q.id }">
						<label class="form-check-label" for="${q.id }"> ${q.name } ${ q.price } VND</label>
					</div>
				</c:forEach>
			</div>
			<button type="submit" class="btn btn-primary">Check out</button>
		</form>
		<div class="mt-3">
			<button type="button" class="btn btn-outline-primary">Back</button>
		</div>
	</div>
</body>

</html>