<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin | List Variation</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@100;300;400;500;600;700;800&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/listStyle.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/reset.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/layout/sidebar.css' />">

</head>
<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<main class="content">
				<div class="list-header">
					<div class="header-breadcrumb">
						<h3 class="heading">Tạo nhân viên mới</h3>
						<nav aria-label="breadcrumb">
							<ul class="breadcrumb">
								<li class="breadcrumb-item"><a class="breadcrumb__link"
									href="">Trang
										chủ</a></li>
								<li class="breadcrumb__divider"></li>
								<li class="breadcrumb__item"><a class="breadcrumb__link"
									href="">Quản lý nhân viên</a>
								</li>
								<li class="breadcrumb__divider"></li>
								<li class="breadcrumb__item">Tạo nhân viên mới</li>
							</ul>
						</nav>
					</div>
				</div>
			<div class="content-container">
				<div class="form-section">
					<form action="adduser/new.htm" method="post" class="row">
						<div class="input-group">
							<div class="input-container">
								<input type="text" required="required" id="username"
									name="username" aria-labelledby="username"><span
									class="highlight"></span><span class="bar"></span> <label
									for="categoryName">Tên người dùng</label>
							</div>
							<div class="input-container">
								<input type="text" required="required" id="email" name="email"
									aria-labelledby="email"><span class="highlight"></span><span
									class="bar"></span> <label for="categoryName">Địa chỉ
									Email</label>
							</div>
							<div class="input-container">
								<input type="text" required="required" id="password"
									name="password" aria-labelledby="password"><span
									class="highlight"></span><span class="bar"></span> <label
									for="categoryName">Mật khẩu</label>
							</div>
							<div class="select-container">
								<select name="permission" id="permission" class="select"
									aria-invalid="false">
									<option value="null" selected="selected">Không</option>
									<c:forEach items="${listPermission}" var="element">
										<option value="${element.id}">${element.value}</option>
									</c:forEach>
								</select> <label for="parentCategoryId">Quyền người dùng</label> <span
									class="select-icon"><i class="fa-solid fa-angle-down"></i></span>
							</div>
							<div class="button-group">
								<button class="button button-submit" type="submit">
									<span> <i class="fa-solid fa-plus"></i>
									</span> <span> Thêm mới </span>
								</button>
								<button class="button button-cancel" type="button">
									<span> <i class="fa-regular fa-circle-xmark"></i>
									</span> <span>Huỷ</span>
								</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</main>
	</div>
	<script type="text/javascript"
		src="<c:url value='/common/assets/js/navbar.js'/>"></script>
</body>
</html>
