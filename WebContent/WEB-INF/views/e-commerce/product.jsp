<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/layout/sidebar.css' />">
<link rel="stylesheet"
	href="<c:url value ='/common/assets/css/reset.css' />">
<link rel="stylesheet"
	href="<c:url value='/common/assets/css/ecommerce/product/style.css'/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	<div class="container-cts">
		<%@include file="/WEB-INF/views/layout/sidebar.jsp"%>
		<main class="content">
			<div class="list-header">
				<div class="header-breadcrumb">
					<h3 class="heading">Chi tiết sản phẩm</h3>
					<nav aria-label="breadcrumb">
						<ul class="breadcrumb">
							<li class="breadcrumb-item"><a class="breadcrumb__link"
								href="#">E-Commerce</a></li>
							<li class="breadcrumb__divider"></li>
							<li class="breadcrumb__item"><a class="breadcrumb__link"
								href="${contextPath}/e-commerce/shop.htm">Shop
									</a></li>
							<li class="breadcrumb__divider"></li>
							<li class="breadcrumb__item">Chi tiết sản phẩm</li>
						</ul>
					</nav>
				</div>
			</div>
			<div class="container-fluid">
				<div class="header-product">
					<div class="product-image">
						<img src="${product.getProductImage()}" alt="Product Image"
							class="img-fluid" alt="Product Image" class="img-fluid" />

					</div>
					<div class="info-product">
						<h1 class="productName">${product.getProduct().getName()}</h1>
						<c:if test="${!onSale}">
							<p class="priceProduct"
								style="color: #FF0000; font-weight: bold;">Giá:
								${product.getPrice()} VND</p>
						</c:if>

						<c:if test="${onSale}">
							<p class="priceProduct-strike-through"
								style="font-weight: bold; text-decoration: line-through; text-decoration-line: line-through; text-decoration-color: black; margin-top: 10px;">Giá:
								${product.getPrice()} VND</p>
							<p class="salePrice"
								style="color: #FF0000; font-weight: bold; margin-top: 10px;">Giá:
								${salePrice} VND</p>
						</c:if>
						<script>
							var money = $
							{
								product.getPrice()
							};
							var formattedPrice = money.toLocaleString('vi-VN',
									{
										maximumFractionDigits : 2
									});
							document.querySelector('.priceProduct').textContent = formattedPrice
									+ " VND";
						</script>
						<form:form action="${product.getId()}.htm"
							modelAttribute="shoppingCartItem">
							<div class="mb-3">
								<label for="quantityInput" class="mr-2">Số lượng</label> <input
									type="number" id="quantityInput" name="quantityInput"
									class="form-control col-4" value="1" min="1" max="10" />
							</div>
							<div class="d-flex">
								<input type="hidden" name="productItem.id" value="${product.id}" />
								<input type="hidden" name="productItem.price"
									value="${product.price}" /> <input type="hidden"
									name="customer.id" value="1" />
								<button type="submit" class="btnAddToCart" name="addToCart">
									Thêm vào giỏ hàng</button>
								<button type="submit" class="btnBuyNow" name="buyNow">
									Mua ngay</button>
							</div>
						</form:form>
						<div></div>
					</div>
				</div>

				<div class="cart-icon">
					<a href="${contextPath}/e-commerce/cart.htm"> <i
						class="fa fa-shopping-cart"></i> <span> ${quantityOrdered}</span>
					</a>

				</div>
				<div class="container">
					<div class="item">
						<div class="item-icon">
							<img src="<c:url value ='/common/assets/icons/original.png' />">
						</div>
						<div class="item-title">100% Original</div>
						<div class="item-subtitle">Tất cả sản phẩm của chúng tôi là
							chính hãng</div>
					</div>
					<div class="item">
						<div class="item-icon">
							<img
								src="<c:url value ='/common/assets/icons/replacement.png' />">
						</div>
						<div class="item-title">10 Day Replacement</div>
						<div class="item-subtitle">Chính sách 1 đổi 1 trong vòng 10
							ngày đầu tiên</div>
					</div>
					<div class="item">
						<div class="item-icon">
							<img src="<c:url value ='/common/assets/icons/warranty.png' />">
						</div>
						<div class="item-title">Year Warranty</div>
						<div class="item-subtitle">Tất cả sản phẩm đều có trên 1 năm
							bảo hành</div>
					</div>
				</div>

				<div class="description">

					<h3 class="description-title">Description</h3>
					<p>Bản nâng cấp 32GB RAM sẽ trao cho MacBook Pro 14 2023 nguồn
						sức mạnh tuyệt vời để dễ dàng đa nhiệm mọi tác vụ nặng và đòi hỏi
						cấu hình chuyên nghiệp nhất. Dung lượng RAM rộng rãi tạo điều kiện
						cho chip xử lý M2 Pro giải phóng được toàn bộ hiệu năng ẩn chứa,
						đem lại trải nghiệm vượt quá kỳ vọng của bạn.</p>
				</div>
				<hr />
				<form:form action="${product.getId()}.htm">
					<label> Đánh giá sản phẩm    </label>
				
					<button name="ratingProduct" type="submit" style="border: none">
						
					</button>
				 </form:form>

				<c:if test="${isBought}">
					<form:form action="${product.getId()}.htm"
						modelAttribute="CustomerReview">
						<div>
						  <input type="hidden" name="ratingValue" id="ratingValue" value=""/>
						  <div class="div_start">
						    <div class="stars">
						      <i class="fas fa-star"></i>
						      <i class="fas fa-star"></i>
						      <i class="fas fa-star"></i>
						      <i class="fas fa-star"></i>
						      <i class="fas fa-star"></i>
						    </div>
						  </div>
						</div>

						<script>
						  const ratingInput = document.getElementById('ratingValue');
						  const stars = document.querySelectorAll('.stars i');
						
						  stars.forEach((star, index) => {
						    star.addEventListener('click', () => {
						      stars.forEach((star, i) => {
						        if (i <= index) {
						          star.classList.add('active');
						        } else {
						          star.classList.remove('active');
						        }
						      });
						      const rating = index + 1;
						      ratingInput.value = rating; // Gán giá trị rating vào trường ẩn
						    });
						  });
						</script>
						<textarea id="comment-input" name="commentInput" rows="5"> </textarea>
						
						<div class="btn_submit_comment">
							<button name="addComment" type="submit" class="btn_comment">
								Bình luận</button>
						</div>
					</form:form>
				</c:if>
				<c:set var="commentList" value="${comments}" />
				<div class="box-comments">
				  <c:forEach var="comment" items="${commentList}">
				    <div class="comment-container">
				      <div class="left-col">
				        <img src="https://d11a6trkgmumsb.cloudfront.net/original/3X/d/8/d8b5d0a738295345ebd8934b859fa1fca1c8c6ad.jpeg" alt="Avatar" class="avatar">
				        <h4 class="username">${comment.getCustomer().getUserName()}</h4>
				      </div>
				      <div class="right-col">
				        <div class="mb-3">
				        	<div class="stars">
								<c:forEach var="i" begin="1" end="5">
									<c:if test="${i <= comment.ratingValue}">
										<i class="fas fa-star active"></i>
									</c:if>
									<c:if test="${i > comment.ratingValue}">
										<i class="fas fa-star"></i>
									</c:if>
								</c:forEach>
							</div>
				          <p class="comment-text">${comment.getComment()}</p>
				        </div>
				      </div>
				    </div>
				    <hr />
				  </c:forEach>
				</div>

			</div>
		</main>
	</div>
	<script type="text/javascript"
		src="<c:url value='/common/assets/js/navbar.js'/>"></script>
</body>
</html>
