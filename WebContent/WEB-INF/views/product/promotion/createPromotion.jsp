<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form tạo khuyến mãi</title>
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/reset.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/layout/sidebar.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/listStyle.css' />">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@100;300;400;500;600;700;800&display=swap"
	rel="stylesheet" />
<style>
form {
	margin: 20px auto;
	width: 50%;
	padding: 20px;
	border: 2px solid #ccc;
	border-radius: 10px;
}

label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

input[type="text"], select, input[type="number"], input[type="date"] {
	padding: 5px;
	border-radius: 5px;
	border: 1px solid #ccc;
	margin-bottom: 10px;
	width: 100%;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
	margin-top: 10px;
}

input[type="submit"]:hover {
	background-color: #3e8e41;
}
</style>
</head>
<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<div class="content">
			<div class="header-breadcrumb">
				<h3 class="heading">Danh sách sản phẩm</h3>
				<nav aria-label="breadcrumb">
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a class="breadcrumb__link"
							href="https://getbootstrap.com/docs/5.0/components/breadcrumb/#example">Trang
								chủ</a></li>
						<li class="breadcrumb__divider"></li>
						<li class="breadcrumb__item"><a class="breadcrumb__link"
							href="https://getbootstrap.com/docs/5.0/components/breadcrumb/#example">ECommrece</a>
						</li>
						<li class="breadcrumb__divider"></li>
						<li class="breadcrumb__item">Danh sách sản phẩm</li>
					</ul>
				</nav>
			</div>
			<form:form action="promotion.htm">
				<label for="promotion-name">Tên khuyến mãi:</label>
				<input type="text" id="promotion-name" name="promotion-name"
					required>

				<label for="promotion-description">Mô tả khuyến mãi:</label>
				<input type="text" id="promotion-description"
					name="promotion-description" required>

				<label for="brand">Nhãn hàng giảm:</label>
				<select id="brand" name="brand" required>
					<option value="">Chọn nhãn hàng</option>
					<c:forEach var="u" items="${categories}">
						<option value="${u.getId()}">${u.getCategoryName()}</option>
					</c:forEach>
				</select>

				<label for="discount-percentage">Phần trăm giảm:</label>
				<input type="number" id="discount-percentage"
					name="discount-percentage" min="1" max="100" required>

				<label for="start-date">Ngày bắt đầu:</label>
				<input type="date" id="start-date" name="start-date" required>

				<label for="end-date">Ngày kết thúc:</label>
				<input type="date" id="end-date" name="end-date" required>

				<input type="submit" value="Tạo khuyến mãi">
			</form:form>
		</div>
	</div>

</body>
</html>