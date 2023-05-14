package ptithcm.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import ptithcm.dao.address.AddressDao;
import ptithcm.model.address.District;
import ptithcm.model.address.Province;
@Transactional
@Controller
@RequestMapping(value = "/customer/")
public class TestController {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	AddressDao addressDao;

	@RequestMapping(value = "newAddress", method = RequestMethod.GET)
	public String showNewAddress(ModelMap model) {
		List<Province> listPros = addressDao.getProvincesList();
		model.addAttribute("listPros", listPros);
		return "customer/newAddress";
	}
	
	
	@RequestMapping(value = "/your-controller-url",method= RequestMethod.GET)
	//@ResponseBody
	public String yourController(@RequestParam("provinceId") Integer provinceId,ModelMap model) {
	    List<District> listDicts = addressDao.getDistricesList(provinceId);
	    Gson gson = new Gson();
	    String json = gson.toJson(listDicts);
	    return json;
	}


}
