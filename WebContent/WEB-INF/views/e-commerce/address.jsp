<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Address</title>
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
			<div class="container-fluid">
				<div class="col-md col-xl-12">
					<div class="box mb-3 mt-3">

						<h3 class="col-md title">Address</h3>
					</div>
					<ul class="list-group">
						<c:forEach var="i" items="${customerAddress}">
							<li class="list-group-item">
								<div class=row>
									<div class="col-md-7">${i.address.detailAddress },
										${i.address.ward }, ${i.address.district }, ${i.address.city }</div>

									<div class="col-md-2">
										<form action="../e-commerce/address/delete.htm" method="post">
											<input type="hidden" name="addressId" value="${i.getId()}">
											<button class="btn btn-outline-primary" id="delete"
												onclick="return confirm('Are you sure you want to delete this address?')">
												Delete</button>
										</form>
									</div>
									<div class="col-md-3">
										<form action="../e-commerce/address/deliver.htm" method="post">
											<input type="hidden" name="addressId" value="${i.getId()}">
											<button class="btn btn-success btn-lg" id="deliver">
												Deliver to this address</button>
										</form>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
					<div class="row mt-3">
						<div class="col-xl-7 ">
							<button type="button" class="btn btn-outline-primary ">
								&#171 Back</button>
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