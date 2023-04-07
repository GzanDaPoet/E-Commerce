<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Product Detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="<c:url value ='/common/assets/thong_css/style.css' />">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">	

<style>
.row {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	padding: 20px;
}

.item {
	flex-basis: calc(33.33% - 20px);
	margin-bottom: 20px;
	background-color: #f2f2f2;
	padding: 20px;
	text-align: center;
}

.item-icon {
	font-size: 40px;
	margin-bottom: 10px;
}

.item-title {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 10px;
}

.item-subtitle {
	font-size: 18px;
	color: #666;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6">
				<img src="${product.getProductImage() }" alt="Product Image"
					class="img-fluid" style="margin-top: 10px" alt="Product Image"
					class="img-fluid" />
			</div>
			<div class="col-lg-6">
				<h1>${product.getProduct().getName()}</h1>
				<p>Price: ${product.getPrice()} VND</p>
				<div class="mb-3">
					<span class="mr-2">Rating:</span>
					<div class="rating">
						<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="fas fa-star"></i> <i class="fas fa-star"></i> <i
							class="far fa-star"></i>
					</div>
				</div>


				<form:form action="${product.getId()}.htm"
					modelAttribute="shoppingCartItem">
					<div class="mb-3">
						<label for="quantityInput" class="mr-2">Quantity:</label> <input
							type="number" id="quantityInput" name="quantityInput"
							class="form-control col-4" value="1" min="1" max="10" />
					</div>
					<div class="d-flex">
						<input type="hidden" name="productItem.id" value="${product.id}" />
						<input type="hidden" name="productItem.price"
							value="${product.price}" /> <input type="hidden"
							name="customer.id" value="1" />
						<button type="submit" class="btn btn-primary">Add to Cart</button>
					</div>
				</form:form>
				<div></div>

			</div>
		</div>

		<div class="cart-icon">
			<i class="fa fa-shopping-cart"></i> <span>${quantityOrdered}</span>
		</div>

		<div>${message}</div>
		<div class="row" style="margin-top: 20px;">
			<div class="item" style="border-radius: 10px;">
				<div class="item-icon">
					<i class="fas fa-laptop"></i>
				</div>
				<div class="item-title">100% Original</div>
				<div class="item-subtitle">Chocolate bar candy canes ice cream
					toffee cookie halvah.</div>
			</div>
			<div class="item" style="border-radius: 10px;">
				<div class="item-icon">
					<i class="fas fa-mobile-alt"></i>
				</div>
				<div class="item-title">10 Day Replacement</div>
				<div class="item-subtitle">Marshmallow biscuit donut dragée
					fruitcake wafer.</div>
			</div>
			<div class="item" style="border-radius: 10px;">
				<div class="item-icon">
					<i class="fas fa-headphones"></i>
				</div>
				<div class="item-title">Year Warranty</div>
				<div class="item-subtitle">Marshmallow biscuit donut dragée
					fruitcake wafer.</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h3>Description</h3>
					<p>${product.getProduct().getDescription() }</p>
				</div>
			</div>
			<hr />
		</div>
	</div>
</body>
</html>
