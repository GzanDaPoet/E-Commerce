package ptithcm.controller;

import java.lang.ProcessBuilder.Redirect;
import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.mapping.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import ptithcm.dao.address.AddressDao;
import ptithcm.model.address.Address;
import ptithcm.model.address.District;
import ptithcm.model.address.Province;
import ptithcm.model.address.Ward;
import ptithcm.model.customer.Customer;
import ptithcm.model.customer.CustomerAddress;
import ptithcm.model.order.OrderLine;
import ptithcm.model.order.OrderStatus;
import ptithcm.model.shop.ShopOrder;
import ptithcm.service.AddressService;
import ptithcm.service.CustomerService;
import ptithcm.util.SessionUtil;

@Transactional
@Controller
@RequestMapping(value = "/customer/")
public class CustomerController {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	AddressService addressService;
	@Autowired
	CustomerService customerService;
	
	
	
	@RequestMapping(value = "newAddress", method = RequestMethod.GET)
	public String newAddress(ModelMap model) {
		List<Province> listPros = addressService.listProvinces();
		model.addAttribute("listPros", listPros);
		return "customer/newAddress";
	}

	@RequestMapping(value = "newAddress", method = RequestMethod.POST)
	public String showNewAddress1(ModelMap model,
			@RequestParam("province") int provinceId, 
			@RequestParam("district") int districtId,
			@RequestParam("ward") int wardId,
			@RequestParam("details") String details,
			HttpServletRequest request) {
		if(SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL") == null)
		{
			return "redirect:/e-commerce/login.htm";
		}
		int id = (int) ((Customer) SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL")).getId();
		if(provinceId != 0) {
			if(districtId != 0) {
				if(wardId != 0) {
					Address newAddress = addressService.newAddressById(provinceId, districtId, wardId);
					newAddress.setDetailAddress(details);
					Session session = sessionFactory.openSession();
					org.hibernate.Transaction t = session.beginTransaction();
					try {
						session.save(newAddress);
						t.commit();
						model.addAttribute("message", "Thêm mới thành công! ");
						System.out.println("done");
					} catch (Exception e) {
						t.rollback();
						model.addAttribute("message", "Thêm mới thất bại! ");
						System.out.println(e);
					} finally {
						session.close();
					}
					CustomerAddress newCA = new CustomerAddress();
					newCA.setAddress(newAddress);
					newCA.setCustomer((Customer) SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL"));
					newCA.setIsDefault(true);
					Session session1 = sessionFactory.openSession();
					org.hibernate.Transaction t1 = session1.beginTransaction();
					try {
						session1.save(newCA);
						t1.commit();
						model.addAttribute("message", "Thêm mới thành công! ");
						System.out.println("done11");
					} catch (Exception e) {
						t1.rollback();
						model.addAttribute("message", "Thêm mới thất bại! ");
						System.out.println(e);
					} finally {
						session1.close();
					}
					System.out.println("Chưa direct lại");
					return "customer/newAddress";
				}
				List<Province> listPros = addressService.listProvinces();
				model.addAttribute("listPros", listPros);
				List<District> listDicts = addressService.listDistricts(provinceId);
				model.addAttribute("listDicts", listDicts);
				List<Ward> listWards = addressService.listWards(districtId);
				model.addAttribute("listWards",listWards);
				model.addAttribute("selectedProvince", provinceId);
				model.addAttribute("selectedDistrict", districtId);
				return "customer/newAddress";
			}
			List<Province> listPros = addressService.listProvinces();
			model.addAttribute("listPros", listPros);
			List<District> listDicts = addressService.listDistricts(provinceId);
			model.addAttribute("listDicts", listDicts);
	        model.addAttribute("selectedProvince", provinceId);
			return "customer/newAddress";
		}
		return "customer/newAddress";
		}


	@RequestMapping(value = "orderManage")
	public String orderManage(HttpServletRequest request, ModelMap model) {
		if(SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL") == null)
		{
			return "redirect:/e-commerce/login.htm";
		}
		int id = (int) ((Customer) SessionUtil.getInstance().getValue(request, "CUSTOMER_MODEL")).getId();
		List<ShopOrder> listOrders = customerService.getShopOrdersById(id);
		model.addAttribute("listOrders",listOrders);
		return "customer/orderManage";
	}

	@RequestMapping(value = "orderManage/{id}")
	public String orderDetails(HttpServletRequest request, ModelMap model,@PathVariable int id){
		List<OrderLine> listLines = customerService.getLines(id);
		model.addAttribute("listLines",listLines);
		ShopOrder shopOrder = customerService.getShopOrderById(id);
		String address = shopOrder.getCustomerAddress().getAddress().getDetailAddress() + ", "
				+ shopOrder.getCustomerAddress().getAddress().getWard() + ", "
				+ shopOrder.getCustomerAddress().getAddress().getDistrict() + ", "
				+ shopOrder.getCustomerAddress().getAddress().getCity();
		model.addAttribute("address",address);
		System.out.println(shopOrder.getOrderStatus().getStatus());
		if (shopOrder.getOrderStatus().getStatus().equals("ON_HOLD")) {
			model.addAttribute("test", true);
		}
		else {
			model.addAttribute("test", false);
		}
		model.addAttribute("sum", shopOrder.getOrderTotal());
		model.addAttribute("id",id );
		return "customer/orderDetails";
	}

	@RequestMapping(value="orderManage/cancel/{orderId}")
	public String cancelOrder(@PathVariable int orderId) {
		ShopOrder shopOrder = customerService.getShopOrderById(orderId);
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setId(4);
		shopOrder.setOrderStatus(orderStatus);
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		if (shopOrder != null) {
			try {
				session.merge(shopOrder);
				t.commit();
				System.out.println("Cap nhat don hang thanh cong");
			} catch (Exception e) {
				System.out.println("Error: " + e.toString());
				t.rollback();
			} finally {
				session.close();
			}
		}
		return "redirect:/customer/orderManage.htm";
	}
	
}
