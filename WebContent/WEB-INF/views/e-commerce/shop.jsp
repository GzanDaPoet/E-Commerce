<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
<title>Shop</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:wght@100;300;400;500;600;700;800&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/layout/sidebar.css'/>">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/reset.css' />">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<div class="content">
			<div class="container mt-4">
				<div class="row">
					<c:forEach var="u" items="${listProduct}">
						<div class="col-sm-3">
							<div class="card">
								<img class="card-img-top" src="${u.getProductImage()}"
									alt="Shoe">
								<div class="card-body">
									<h4 class="card-title">
										<a href="product/${u.getId()}.htm">
											${u.getProduct().getName()}</a>
									</h4>
									<span class="fa fa-star checked"></span> 
									<span class="fa fa-star checked"> </span> 
									<span class="fa fa-star checked"></span> 
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
									<p class="card-text">$70</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/common/assets/js/navbar.js'/>"></script>
</body>
</html>


