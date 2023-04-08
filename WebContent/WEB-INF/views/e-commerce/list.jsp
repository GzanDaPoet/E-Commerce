<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Product List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="<c:url value ='/common/assets/thong_css/style.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/icons/themify-icons/css/themify-icons.css' />">
</head>
<body>

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
			<a href="#">Link 1</a> <a href="#">Link 2</a> <a href="#">Link 3</a>
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
						<td><img
							src="${u.getProductImage() }"
							alt="Product Image" class="product-image mr-2"/>
							${u.product.getName()}</td>
						<td>2022-02-01</td>
						<td><span class="badge badge-success">In stock</span></td>
						<td>$50</td>
						<td><div class="btn-group">
								<div class="ti-settings"></div>
								<ul class="dropdown-menu">
									<li><a class="dropdown-item"
										href="https://minimals.cc/dashboard/user/list">Edit</a></li>
									<li><a class="dropdown-item"
										href="https://minimals.cc/dashboard/user/list">Delete</a></li>
								</ul>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>