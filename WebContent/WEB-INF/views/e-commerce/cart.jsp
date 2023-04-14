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

<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/cart/cart.css' />">

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
				<li class="breadscrum-custom-item"><p>Cart</p></li>
				<li class="breadscrum-custom-item"><span class="dotted"></span>
					<a
					href="http://localhost:8080/com.ecommerce/e-commerce/address.htm">
						Address</a></li>
				<li class="breadscrum-custom-item"><span class="dotted"></span>
					<a
					href="http://localhost:8080/com.ecommerce/e-commerce/payment.htm">
						Payment</a></li>
			</ul>
		</div>
		<div class="row">
			<div class="col-xl-6 col-md">
				<div class="box">
					<h3 class="col-sm-12 title">Cart</h3>
					<table class="table">
						<thead>

							<tr>
								<th>Product</th>
								<th>Quantity</th>
								<th>Price</th>
								<th>Total Price</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${shoppingCart}">
								<tr>
									<td>${i.productItem.product.getName()}</td>

									<td><div class="btn-group btn-group-justified">
											<a href="#" class=" btn btn-outline-primary" id="decrease">-</a>
											<button disabled class="btn btn-outline-primary"
												id="quantity">${i.quantity}</button>
											<a href="#" class="btn btn-outline-primary" id="increase">+</a>

										</div></td>

									<td>${i.productItem.getPrice()}VNĐ</td>
									<td>${i.productItem.getPrice() * i.quantity }VNĐ</td>
									<td><form action="/e-commerce/cart/delete" method="post">
											<input type="hidden" name="productId"
												value="${i.productItem.product.getId()}">
											<button type="submit" class="btn btn-outline-primary">Del</button>
										</form></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<button type="button" class="btn btn-outline-primary">
							&#171 Continue Shopping</button>
					</div>
				</div>
			</div>

			<div class="col-xl-3">
				<div class="box2">
					<div>
						<h4 class="col-sm-12 title">Order Summary</h4>
						<h5>Sub total: ${sum} VND</h5>
						<hr>
						<h4>Total: ${sum} VND</h4>
					</div>
					<div>
						<form action="address.htm" method="post">
							<button type="submit" class="btn btn-success btn-lg"
								name="checkOut">Check Out</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>