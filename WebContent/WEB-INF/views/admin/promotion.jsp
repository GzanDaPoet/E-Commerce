<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>Form tạo khuyến mãi</title>
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
	<form:form action="promotion.htm">
		<label for="promotion-name">Tên khuyến mãi:</label>
		<input type="text" id="promotion-name" name="promotion-name" required>

		<label for="promotion-description">Mô tả khuyến mãi:</label>
		<input type="text" id="promotion-description" name="promotion-description" required>

		<label for="brand">Nhãn hàng giảm:</label>
		<select id="brand" name="brand" required>
			<option value="">Chọn nhãn hàng</option>
			<c:forEach var="u" items="${categories}">
				<option value="${u.getId()}"> ${u.getCategoryName()}</option>
			</c:forEach>
		</select>

		<label for="discount-percentage">Phần trăm giảm:</label>
		<input type="number" id="discount-percentage" name="discount-percentage" min="1" max="100" required>

		<label for="start-date">Ngày bắt đầu:</label>
		<input type="date" id="start-date" name="start-date" required>

		<label for="end-date">Ngày kết thúc:</label>
		<input type="date" id="end-date" name="end-date" required>

		<input type="submit" value="Tạo khuyến mãi">
	</form:form>
	
	
	<div> ${message}</div>
</body>
</html>