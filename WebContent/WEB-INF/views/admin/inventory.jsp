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
	href="<c:url value ='/common/assets/css/layout/sidebar.css' />">

</head>

<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<div class="content">
			<div class="container-fluid">
				<form action="../admin/inventory/receive.htm" method="post">
					<div class="container mt-3">
						<div class="row">
							<div class="col-md-6">
								<label for="select1">Agency</label> <select class="form-select"
									id="agency" name="agency">
									<c:forEach items="${listAgency}" var="element">
										<option value="${element.id}">${element.name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-6">
								<label for="select2">Status</label> <select class="form-select"
									id="status" name="status">
									<c:forEach items="${listStatus}" var="element">
										<option value="${element.id}">${element.status}</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<br>
					<br>
					<div id="product-list">
						<div class="row mb-3 mt-3">
							<div class="col">
								<input type="text" class="form-control"
									placeholder="Product Item ID" name="productItem">
							</div>
							<div class="col">
								<input type="text" class="form-control" placeholder="Quanlity"
									name="qty">
							</div>
							<div class="col">
								<input type="text" class="form-control" placeholder="Price"
									name="price">
							</div>
							<div class="col-1">
								<button type="button" class="btn btn-danger"
									onclick="removeProduct(this)">
									<i class="bi bi-trash"></i> Del
								</button>
							</div>
						</div>
					</div>
					<button type="button" class="btn btn-primary"
						onclick="addProduct()">Add</button>
					<script  type="text/javascript"
		src="<c:url value='/common/assets/js/inventory.js'/>"> </script>
					<button type="submit">Submit</button>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/common/assets/js/navbar.js'/>"></script>
</body>

</html>