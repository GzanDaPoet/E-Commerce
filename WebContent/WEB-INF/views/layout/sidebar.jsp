<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<aside class="layout">
	<div class="sidebar">
		<Button class="sidebar_button" id="sidebar_button">close</Button>
		<div class="sidebar__header">
			<a href="#" class="sidebar__header-navigate">
				<div>
					<img src="<c:url value='/common/images/logo/logo.png'/>" alt="" />
				</div>
			</a> <a href="#" class="sidebar__header-profile">
				<div class="content">
					<div class="avatar">
						<img
							src="https://images.unsplash.com/photo-1613200510878-1629a870b983?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80"
							alt="avatar" />
					</div>
					<div class="information">
						<h6>Minimal UI</h6>
						<p>admin</p>
					</div>
				</div>
			</a>
		</div>
		<div class="menu">
			<h4>Chung</h4>
			<ul class="menu">
				<li class="menu-item"><a
					href="${contextPath}/e-commerce/shop.htm" class="menu-item-btn-s">
						<div class="icon">
							<span><i class="fa-solid fa-gauge-high"></i></span>
						</div>
						<div class="label">
							<span>Trang chủ</span>
						</div>
				</a></li>
				<div class="cf-menu">
					<li class="menu-item"><span class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-shop"></i></span>
							</div>
							<div class="label">
								<span>E-Commerce</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</span></li>
					<ul class="submenu">
						<li class="submenu-item"><a
							href="${contextPath}/e-commerce/shop.htm">Cửa hàng</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/e-commerce/list.htm">Danh sách sản phẩm</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/e-commerce/cart.htm">Thanh toán</a></li>
					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><span class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-id-card-clip"></i></span>
							</div>
							<div class="label">
								<span>Người dùng</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</span></li>
					<ul class="submenu">
						<li class="submenu-item"><a
							href="${contextPath}/customer/profile.htm">Trang cá nhân</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/customer/orderManage.htm">Quản lý đơn hàng</a></li>
					</ul>
				</div>
				<li class="menu-item"><a href="#" class="menu-item-btn-s">
						<div class="icon">
							<span><i class="fa-solid fa-chart-line"></i></span>
						</div>
						<div class="label">
							<span>Phân tích</span>
						</div>
				</a></li>
			</ul>
		</div>
		<div class="menu">
			<h4>Quản lý</h4>
			<ul class="menu">
				<div class="cf-menu">
					<li class="menu-item"><span class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-id-card-clip"></i></span>
							</div>
							<div class="label">
								<span>Quản lý đơn hàng</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</span></li>
					<ul class="submenu">
						<li class="submenu-item"><a
							href="${contextPath}/admin/manage-ordered/list.htm">Danh sách
								đơn hàng đã đặt</a></li>
					</ul>
					<ul class="submenu">
						<li class="submenu-item"><a href="${contextPath}/delivery/listDeliveryOrder.htm">Đang vận chuyển</a>
						</li>
					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><span class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-id-card-clip"></i></span>
							</div>
							<div class="label">
								<span>Quản lý người dùng</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</span></li>
					<ul class="submenu">
						<li class="submenu-item"><a
							href="${contextPath}/user/profile.htm">Thông tin cá nhân</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/user/list.htm">Danh sách nhân viên</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/user/new.htm">Tạo nhân viên</a></li>
					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><span class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-id-card-clip"></i></span>
							</div>
							<div class="label">
								<span>Quản lý khách hàng</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</span></li>
					<ul class="submenu">
						<li class="submenu-item"><a href="#">Danh sách khách hàng</a>
						</li>

					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><span class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-truck-ramp-box"></i></span>
							</div>
							<div class="label">
								<span>Đại lý</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</span></li>
					<ul class="submenu">
						<li class="submenu-item"><a href="#">Danh sách đại lý</a></li>
						<li class="submenu-item"><a href="#">Thêm đại lý</a></li>
					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><span class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-receipt"></i></span>
							</div>
							<div class="label">
								<span>Hoá đơn</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</span></li>
					<ul class="submenu">
						<li class="submenu-item"><a href="#">Danh sách hoá đơn</a></li>
						<li class="submenu-item"><a href="#">Thêm hoá đơn</a></li>
					</ul>
				</div>
			</ul>
		</div>
		<div class="menu">
			<h4>Sản phẩm</h4>
			<ul class="menu">
				<div class="cf-menu">
					<li class="menu-item"><a class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-mobile-retro"></i></span>
							</div>
							<div class="label">
								<span>Quản lý sản phẩm</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</a></li>
					<ul class="submenu">
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/list.htm">Danh sách sản
								phẩm</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/new.htm">Tạo mới sản phẩm</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/new.htm">Nhập sản phẩm</a></li>
					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><a class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-tags"></i></span>
							</div>
							<div class="label">
								<span>Quản lý nhãn</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</a></li>
					<ul class="submenu">
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/category/list.htm">Danh
								sách nhãn</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/category/new.htm">Tạo mới
								nhãn</a></li>
					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><a class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-atom"></i></span>
							</div>
							<div class="label">
								<span>Quản lý thuộc tính</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</a></li>
					<ul class="submenu">
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/variation/list.htm">Danh
								sách thuộc tính</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/variation/new.htm">Tạo mới
								thuộc tính</a></li>
					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><a class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-table-list"></i></span>
							</div>
							<div class="label">
								<span>Giá trị thuộc tính</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</a></li>
					<ul class="submenu">
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/variation-option/list.htm">Danh
								sách giá trị</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/variation-option/new.htm">Tạo
								mới giá trị</a></li>
					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><a class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-percent"></i></span>
							</div>
							<div class="label">
								<span>Quản lý khuyến mãi</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</a></li>
					<ul class="submenu">
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/promotion/list.htm">Danh
								sách khuyến mãi</a></li>
						<li class="submenu-item"><a
							href="${contextPath}/admin/product/promotion/create.htm">Tạo
								mới khuyến mãi</a></li>
					</ul>
				</div>
				<div class="cf-menu">
					<li class="menu-item"><a class="menu-item-btn">
							<div class="icon">
								<span><i class="fa-solid fa-shield"></i></span>
							</div>
							<div class="label">
								<span>Quản lý bảo hành</span>
							</div>
							<div class="icon">
								<span><i class="fa-solid fa-angle-down"></i></span>
							</div>
					</a></li>
					<ul class="submenu">
						<li class="submenu-item"><a href="#">Danh sách bảo hành</a></li>
						<li class="submenu-item"><a href="#">Tạo mới bảo hành</a></li>
					</ul>
				</div>
			</ul>
		</div>
	</div>
</aside>