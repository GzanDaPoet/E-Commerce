<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Shop</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/thong_css/style.css' />">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">
		<div class="row">
			<c:forEach var="u" items="${listProduct}">
				<div class="col-sm-3">
					<div class="card">
						<img class="card-img-top" src="${u.getProductImage()}" alt="Shoe">
						<div class="card-body">
							<h4 class="card-title">${u.getName()}</h4>
							<span class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span class="fa fa-star"></span>
							<span class="fa fa-star"></span>
							<p class="card-text">$70</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</html>


