<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Product List</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@100;300;400;500;600;700;800&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<c:url value ='/common/assets/thong_css/style.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/icons/themify-icons/css/themify-icons.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/layout/sidebar.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/reset.css' />">

</head>

<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<div class="content">
			<c:if test="${not empty USER_MODEL} }">
			da dang nhap ${USER_MODEL.username}
		</c:if>
			${USER_MODEL.username}
			<div class="row-container">
				<select class="status-dropdown">
					<option value="all">In stock</option>
					<option value="active">In stock</option>
					<option value="inactive">Out of stock</option>
				</select> <input type="text" class="search-box" placeholder="Search...">
			</div>

			<div class="dropdown">
				<button class="dropbtn">Dropdown</button>
				<div class="dropdown-content">
					<a href="#">Link 1</a> <a href="#">Link 2</a> <a href="#">Link
						3</a>
				</div>
			</div>


			<div class="container mt-5">
				<table class="table">
					<thead>
						<tr>
							<th>Product</th>
							<th>Create at</th>
							<th>Status</th>
							<th>Price</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${listProduct}">
							<tr>
								<td><img src="${u.getProductImage() }" alt="Product Image"
									class="product-image mr-2" /> ${u.product.getName()}</td>
								<td>2022-02-01</td>
								<td><span class="badge badge-success">In stock</span></td>
								<td>$50</td>
								<td>
									<div class="btn-group">
										<div class="ti-settings"></div>
										<ul class="dropdown-menu">
											<li><a class="dropdown-item"
												href="https://minimals.cc/dashboard/user/list">Edit</a></li>
											<li><a class="dropdown-item"
												href="https://minimals.cc/dashboard/user/list">Delete</a></li>
										</ul>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/common/assets/js/navbar.js'/>"></script>
</body>

</html>