<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<div class="btn_filter">
			<form action="list.htm" >
				<select
					id="selectOption" name="selectOption">
					<option value="all">All</option>
					<option value="active">In stock</option>
					<option value="inactive">Out of stock</option>
				</select>
				<button name="filter" type="submit">Filter</button>
			</form>
		</div>
		<form method="POST" action="list.htm">
			<input type="text" name="searchText" placeholder="Tìm kiếm sản phẩm">
		</form> 
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
						<td><span class="badge">${u.getStatus()}</span></td>
						<td>50$</td>
						<td><div class="btn-group">
								<div class="ti-settings"></div>
								<ul class="dropdown-menu">
									<li>
										<form action="list.htm" method="get">
											<input type="hidden" name="productId" value="${u.getId()}">
											<button type="submit">Sửa</button>
										</form>
									</li>
									<li>
										<form action="list.htm" method="post">
											<input type="hidden" name="productId" value="${u.getId()}">
											<button name= "deleteProduct" type="submit">Xóa</button>
										</form>
									</li>
								</ul>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>