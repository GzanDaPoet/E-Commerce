<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Product Detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/layout/sidebar.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/reset.css' />">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-xxxxxxx" crossorigin="anonymous" />

	
<style>
<style>

.row {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	align-items: center;
}

.item {
	flex-basis: calc(25% - 20px);
	margin-bottom: 20px;
	background-color: #f2f2f2;
	padding: 20px;
	text-align: center;
	margin-right: 50px;
	margin-left: 50px;'
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

.description-title {
	font-weight: bold;
	font-size: 30px;
	margin-bottom: 10px;
}


/* Thiết lập kiểu cho phần tử trường văn bản */
input[type="text"], textarea {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	background-color: #f8f8f8;
	resize: none;
}

/* Thiết lập kiểu cho phần tử container */
.comment-container {
	padding: 20px;
	border-radius: 15px;
	background-color: beige;
	margin-top: 10px;
	overflow-y: scroll;
}

.comment {
	padding: 10px;
	margin-bottom: 5px;
	border-radius: 5px;
	font-size: 20px;
}

.comment .author {
	font-weight: bold;
}

.comment .date {
	color: #aaa;
	font-size: 0.8em;
}

.comment .message {
	margin-top: 5px;
	font-size: 0.9em;
}

.cart-icon {
	position: fixed;
	bottom: 200px;
	right: 20px;
	background-color: #ccc;
	width: 65px;
	height: 65px;
	border-radius: 50%;
	text-align: center;
	line-height: 50px;
	font-size: 24px;
	padding: 8px;
}

.cart-icon span {
	position: relative;
	height: 18px;
	right: -5px;
	top: -15px;
	background-color: red;
	color: white;
	font-size: 15px;
	padding: 5px;
	border-radius: 15px;
	min-width: 20px;
	text-align: center;
	justify-content: center;
	align-items: center;
}

.description {
	padding: 10px;
	background-color: aquamarine;
	border-radius: 10px;
	
}

.btnAddToCart {
	width: 120px;
	background-color: coral;
	border-radius: 5px;
	border: none;
	padding-top: 5px;
	padding-bottom: 5px;
	color: #fff;
}

.btn_comment {
	width: 80px;
	padding: 4px;
	background-color: burlywood;
	border-radius: 10px;
	border: none;
	display: block;
	margin: 0 auto;
}

.title_comment {
	font-size: 25px;
	font-weight: 500;
}

.info-product {
	margin-top: 10px;
}

.productName {
	font-size: 40px;
	font-weight: bold;
}

.priceProduct {
	margin-top: 15px;
}

.mb-3 {
	margin-top: 15px;
}


.form-control {
	margin-top: 10px;
}

.rating {
  display: flex;
  position: relative;
  height: 20px;
  line-height: 20px;
  font-size: 20px;
}
.rating .star {
  display: flex;
  box-sizing: border-box;
  padding: 0 10px;
  cursor: pointer;
  transition: color 200ms;
}

.star {
	color: green;
}

.rating .star:hover,
.rating .star.active {
  color: #FFD700;
}


</style>
</head>
<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-6">
						<img
							src="${product.getProductImage()}"
							alt="Product Image" class="img-fluid" style="margin-top: 10px"
							alt="Product Image" class="img-fluid" />
					</div>
					<div class="info-product">
						<h1 class= "productName">${product.getProduct().getName()}</h1>
						<p class= "priceProduct"> ${product.getPrice()} VND</p>
						<div class="mb-3">
							<span class="mr-2">Rating:</span>
							<span class="fa fa-star checked"></span> 
							<span class="fa fa-star checked"></span> 
							<span class="fa fa-star checked"></span> 
							<span class="fa fa-star"></span> 
							<span class="fa fa-star"></span>
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
									value="${product.price}" /> <input
									type="hidden" name="customer.id" value="1" />
								<button type="submit" class="btnAddToCart" name="addToCart">
									Add to Cart</button>
							</div>
						</form:form>
						<div></div>
					</div>
				</div>

				<div class="cart-icon">
					<i class="fa fa-shopping-cart"></i> <span> ${quantityOrdered}</span>
				</div>
				<div class="row" style="margin-top: 20px">
					<div class="item" style="border-radius: 10px">
						<div>
							<img src="<c:url value ='/common/assets/icons/original.png' />">
						</div>
						<div class="item-title">100% Original</div>
						<div class="item-subtitle">Tất cả sản phẩm của chúng tôi là
							chính hãng. Được nhập về từ nhiều hãng nổi tiếng</div>
					</div>
					<div class="item" style="border-radius: 10px">
						<div class="item-icon">
							<img src="<c:url value ='/common/assets/icons/replacement.png' />">
						</div>
						<div class="item-title">10 Day Replacement</div>
						<div class="item-subtitle">Chính sách 1 đổi 1 trong vòng 10
							ngày đầu tiên</div>
					</div>
					<div class="item" style="border-radius: 10px">
						<div class="item-icon">
							<img src="<c:url value ='/common/assets/icons/warranty.png' />">
						</div>
						<div class="item-title">Year Warranty</div>
						<div class="item-subtitle">Tất cả sản phẩm đều có trên 1 năm
							bảo hành</div>
					</div>
				</div>
				<div class="description">
					<div class="row">
						<div class="col-md-6">
							<h3 class="description-title">Description</h3>
							<p>Bản nâng cấp 32GB RAM sẽ trao cho MacBook Pro 14 2023
								nguồn sức mạnh tuyệt vời để dễ dàng đa nhiệm mọi tác vụ nặng và
								đòi hỏi cấu hình chuyên nghiệp nhất. Dung lượng RAM rộng rãi tạo
								điều kiện cho chip xử lý M2 Pro giải phóng được toàn bộ hiệu
								năng ẩn chứa, đem lại trải nghiệm vượt quá kỳ vọng của bạn.</p>
						</div>
					</div>
				</div>
				<hr/>
				<form:form action="${product.getId()}.htm"
					modelAttribute="CustomerReview">
					<div class="title_comment">Bình luận</div>
					<label for="comment-input">Nhập comment</label>
					<textarea id="comment-input" name="commentInput" rows="5"> </textarea>
					<div class="btn_submit_comment">
						<button name="addComment" type="submit" class="btn_comment">
							Submit</button>
					</div>
				</form:form>
				<div class="comment-container">
					<div class="comment">
						<c:forEach var="c" items="${comments}">
							<div class="author">${c.getCustomer().getUserName()}</div>
							<div class="message">${c.getComment()}</div>
							<hr/>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/common/assets/js/navbar.js'/>">
	</script>
</body>
</html>
