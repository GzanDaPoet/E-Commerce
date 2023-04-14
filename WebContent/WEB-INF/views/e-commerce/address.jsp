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
				<li class="breadscrum-custom-item"><a
					href="http://localhost:8080/com.ecommerce/e-commerce/cart.htm">Cart</a>
					&#8226</li>
				<li class="breadscrum-custom-item">Address &#8226</li>
				<li class="breadscrum-custom-item"></span> <a
					href="http://localhost:8080/com.ecommerce/e-commerce/payment.htm">Payment</a>
				</li>
			</ul>
		</div>
		<div class="row">
			<div class="col-xl-9 col-md">
				<div class="box mb-3">

					<h3 class="col-md title">Address</h3>
				</div>
				<ul class="list-group">
					<c:forEach var="i" items="${customerAddress}">
						<li class="list-group-item">
							<div class=row>
								<div class="col-md-7">${i.address.detailAddress }, ${i.address.ward },
									${i.address.district }, ${i.address.city }</div>

								<div class="col-md-2">
									<form action="../e-commerce/address/delete.htm" method="post">
										<input type="hidden" name="addressId" value="${i.getId()}">
										<button class="btn btn-outline-primary" id="delete">
											Delete</button>
									</form>
								</div>
								<div class="col-md-3">
									<form action="../e-commerce/address/deliver.htm" method="post">
										<input type="hidden" name="addressId" value="${i.getId()}">
										<button class="btn btn-outline-primary" id="deliver">
											Deliver to this address</button>
									</form>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="row mt-3">
				<div class="col-xl-7 ">
					<button type="button" class="btn btn-outline-primary ">
						&#171 Back</button>
				</div>
				<div class="col-xl-5">
					<button type="button" class="btn btn-outline-primary">Add
						new address</button>
				</div>
			</div>
		</div>

	</div>
</body>

</html>