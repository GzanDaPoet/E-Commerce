<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Create User</title>
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
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/admin/addUser.css' />">

</head>

<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<div class="content">
			<div class="container-fluid">
					<h3 class="col-sm-12 title">Create User</h3>
				<div class="form-section">
					<form action="" method="post" class="row">
						<div class="col-xl-7 form-floating mb-3 mt-3">
							<input type="text" class="form-control" name="full-name"
								placeholder="Enter full-name"> <label for="full-name">Full
								Name</label>
						</div>
						<div class="col-xl-7 form-floating mb-3 mt-3">
							<input type="email" class="form-control" name="email"
								placeholder="Enter email"> <label for="email">Email
								Address</label>
						</div>
						<div class="col-xl-7 form-floating mb-3 mt-3">
							<input type="tel" class="form-control" name="phone-number"
								placeholder="Enter phone-number"> <label
								for="phone-number">Phone Number</label>
						</div>
						
						<div class="submit-section">
							<input type="button" value="Create User" class="create-btn">
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/common/assets/js/navbar.js'/>"></script>
</body>

</html>