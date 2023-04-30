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
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/reset.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/cart/cart.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/layout/sidebar.css' />">
</head>

<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<div class="content">
			<div class="container">

				<div class="row">
					<div class="col-xl-8 col-md mt-3 mb-3">
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

											<td><div class="col">
													<div class="col-6">
														<div class="btn-group btn-group-justified">
															<form action="../e-commerce/cart/decrease.htm"
																method="post">
																<input type="hidden" name="productId"
																	value="${i.getId()}">
																<button class="btn btn-outline-primary" id="decrease">-</button>
															</form>
															<button disabled class="btn btn-outline-primary"
																id="quantity">${i.quantity}</button>
															<form action="../e-commerce/cart/increase.htm"
																method="post">
																<input type="hidden" name="productId"
																	value="${i.getId()}">
																<button class="btn btn-outline-primary" id="increase">+</button>
															</form>
														</div>
													</div>
													<div class="col-6">
														<p>Available:${i.productItem.quantityInStock}</p>
													</div>
												</div>
											</td>

											<td>${i.productItem.getPrice()}VNĐ</td>
											<td>${i.productItem.getPrice() * i.quantity }VNĐ</td>
											<td>
												<form action="../e-commerce/cart/delete.htm" method="post">
													<input type="hidden" name="productId" value="${i.getId()}">
													<button type="submit" class="btn btn-outline-primary"
														onclick="return confirm('Are you sure you want to delete this product?')">Del</button>
												</form>
											</td>


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

					<div class="col-xl-3 mt-3 mb-3">
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
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/common/assets/js/navbar.js'/>"></script>
</body>

</html>