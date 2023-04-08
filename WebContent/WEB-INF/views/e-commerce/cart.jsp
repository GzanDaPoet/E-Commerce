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
<script src="https://kit.fontawesome.com/dbd4881242.js" crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="<c:url value ='/common/assets/css/check-out.css' />">
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<h2 class="col-sm-12 title">Check Out</h2>
			<ul class="col-sm-12 breadscrum-custom">
				<li class="breadscrum-custom-item"><a href="http://">Dashboard</a>
				</li>
				<span class="dotted"></span>
				<li class="breadscrum-custom-item"><a href="http://">E-Commerce</a>
				</li>
				<span class="dotted"></span>
				<li class="breadscrum-custom-item">Check Out</li>
			</ul>
		</div>
		<div class="row">
			<ul class="col-xl-2 breadscrum-custom">
				<li class="breadscrum-custom-item"><a href="http://">Cart</a></li>
				<span class="dotted"></span>
				<li class="breadscrum-custom-item"><a href="http://">Billing
						& Address</a></li>
				<span class="dotted"></span>
				<li class="breadscrum-custom-item"><a href="http://">Payment</a>
				</li>
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
						 <c:forEach var = "i" items = "${cart}">
							<tr>
								<td>${i.id }</td>
								<td>${1}</td>
								<td>100$</td>
								<td>500$</td>
								<td><button type="button" class="btn btn-outline-primary">Del</button>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<button type="button" class="btn btn-outline-primary">
							Continue Shopping</button>
					</div>
				</div>
			</div>

			<div class="col-xl-3">
				<div class="box2">
					<div>
						<h4 class="col-sm-12 title">Order Summary</h4>
						<h5>Sub total:</h5>
						<h5>Discount:</h5>
						<h5>Shipping:</h5>
						<hr>
						<h4>
							Total:
							</h5>
					</div>
					<div class="row">
						<div class="col-xl-9 form-floating mb-3">
							<input type="text" class="form-control" id="Discount"> <label
								for="discount">Discount</label>
						</div>
						<div class="col-xl-3">
							<button type="button" class="btn btn-outline-success">Apply</button>
						</div>
					</div>
					<div>
						<button type="button" class="btn btn-success btn-lg btn-center">Check
							Out</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	</div>
</body>

</html>