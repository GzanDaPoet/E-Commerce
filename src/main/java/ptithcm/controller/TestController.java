package ptithcm.controller;

import java.lang.ProcessBuilder.Redirect;
import java.time.ZonedDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
import ptithcm.service.AddressService;
import ptithcm.util.SessionUtil;

@Transactional
@Controller
@RequestMapping(value = "/customer/")
public class TestController {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	AddressService addressService;
	
	
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
		System.out.println(provinceId);
		System.out.println(districtId);
		System.out.println(wardId);
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
	public String orderManage() {
		return "customer/orderManage";
	}

}
