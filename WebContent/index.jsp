<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> -->
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Check Out</title>
<script src="https://kit.fontawesome.com/dbd4881242.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/cart/cart.css' />">

</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<h2 class="col-sm-12 title">Inventory recieve</h2>
			<ul class="col-sm-12 breadscrum-custom">
				<li class="breadscrum-custom-item"><a href="http://">Dashboard</a>
				</li>
				<span class="dotted"></span>
				<li class="breadscrum-custom-item"><a href="http://">Inventory</a>
				</li>
				<span class="dotted"></span>
				<li class="breadscrum-custom-item">Recieve</li>
				<span class="dotted"></span>
				<li class="breadscrum-custom-item">Recieve Details</li>
			</ul>
		</div>
		<form>
			<div class="box">
				<div class="row">
					<div class="col-md-6">
						<label for="select1">Agency</label> <select id="select1"
							name="select1">
							<option value="option1">Apple</option>
							<option value="option2">Sam sung</option>
							<option value="option3">Nokia</option>
							<option value="option4">Oppo</option>
						</select>
					</div>
					<div class="col-md-6">
						<label for="select2">Status</label> <select id="select2"
							name="select2">
							<option value="option1">Đã nhận</option>
							<option value="option2">Đang vận chuyển</option>
							<option value="option3">hmm</option>
							<option value="option4">Test</option>
						</select>
					</div>

				</div>
			</div>
			<div class="box mt-3">
				<h5>Chi tiết đơn nhập:</h5>
				<div id="input-container">
					
				</div>
				<button onclick="addInput(event)">Add</button>
				<script src="common/assets/recieve.js" defer></script>
			</div>
		</form>
	</div>
</body>

</html>