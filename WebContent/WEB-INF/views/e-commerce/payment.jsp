<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Cart</title>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://kit.fontawesome.com/dbd4881242.js"
	crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@100;300;400;500;600;700;800&display=swap"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.success-message {
	background-color: #4CAF50;
	color: white;
	padding: 20px;
	margin-bottom: 20px;
}
</style>
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/layout/sidebar.css' />">
</head>

<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<div class="content">
			<div class="container-fluid">
				<form action="../checkout.htm" method="post">
					<div class="row">
						<div class="col-xl-8 col-md ml-3">
							<div class="form-group">
								<div>
									<h3 class="col-xl-1 col-md title">Payment</h3>
								</div>
								<c:forEach var="i" items="${payment}">
									<div class="form-check">
										<input class="form-check-input" type="radio"
											name="PaymentMethod" id="${i.id }" value="${i.id }" >
										<label class="form-check-label" for="${i.id }">
											${i.paymentType.status } Ngày hết hạn: ${ i.expiry } VND</label>
									</div>
								</c:forEach>
							</div>
							<div class="form-group">

								<div>
									<h3 class="col-xl-1 col-md title">Shipping</h3>
								</div>
								<c:forEach var="q" items="${shipping}">
									<div class="form-check">
										<input class="form-check-input" type="radio"
											name="ShippingMethod" id="${q.id }" value="${q.price }" >
										<label class="form-check-label" for="${q.id }">
											${q.name } ${ q.price } VND</label>
									</div>
								<script type="text/javascript"
									src="<c:url value='/common/assets/js/payment.js'/>"></script>
								</c:forEach>
							</div>
						</div>
						<hr>
						<div class="col-xl-4 col-md ml-3">
							<div class="box2">
								<div>
									<h4 class="col-sm-12 title">Order Summary</h4>
									<h5>Sub total: <span id="total-price">${sum}</span></h5>
									<h5>Shipping: <span id="shipping-price"></span> </h5> 
									<hr>
									<h4>Total: <span id="total"></span></h4>
								</div>
								<div>
									<button type="submit" class="btn btn-success btn-lg">Check
										out</button>
								</div>

							</div>
						</div>
					</div>
					<div class="mt-3">
						<button type="button" class="btn btn-outline-primary"
							onclick="window.location='${contextPath}/e-commerce/address.htm'">&#171;
							Back</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/common/assets/js/navbar.js'/>"></script>
</body>

</html>