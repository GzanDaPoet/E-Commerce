package ptithcm.controller;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.realtut.service.UserService;

import ptithcm.model.agency.Agency;
import ptithcm.model.inventory.InventoryReceiving;
import ptithcm.model.inventory.InventoryReceivingDetails;
import ptithcm.model.inventory.StatusReceiving;
import ptithcm.service.AgencyService;
import ptithcm.service.InventoryService;
import ptithcm.service.ProductService;

@Transactional
@Controller
@RequestMapping("/admin/")
public class InventoryController {

	@Autowired
	AgencyService agencyService;
	@Autowired
	InventoryService inventoryService;
	@Autowired
	ProductService productService;
	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping(value = "inventory")
	public String showInventoryReceive(ModelMap modelMap) {
		List<Agency> allAgencies = agencyService.getListAgencies();
		modelMap.addAttribute("listAgency", allAgencies);
		List<StatusReceiving> allStatus = inventoryService.getAllStatusReceivings();
		modelMap.addAttribute("listStatus", allStatus);
		return "admin/inventory";
	}

	@RequestMapping(value = "inventory/receive", method = RequestMethod.POST)
	public String newInventoryReceive(ModelMap modelMap, @RequestParam("agency") int agencyId,
			@RequestParam("status") int statusId,
			@RequestParam(value = "productItem", required = false) List<Integer> productItems,
			@RequestParam(value = "qty", required = false) List<Integer> qtys,
			@RequestParam(value = "price", required = false) List<Integer> prices) {
		InventoryReceiving newInventoryReceiving = new InventoryReceiving();
		Date sqlDate = new Date(System.currentTimeMillis());
		newInventoryReceiving.setDate(sqlDate);
		newInventoryReceiving.setUser(inventoryService.getUserById(9));
		newInventoryReceiving.setAgency(agencyService.getAgencyById(agencyId));
		newInventoryReceiving.setStatusReceiving(agencyService.getStatusReceivingById(statusId));
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(newInventoryReceiving);
			t.commit();

			System.out.println("done");
		} catch (Exception e) {
			t.rollback();

			System.out.println(e);
		} finally {
			session.close();
		}
		for(int i = 0;i < productItems.size();i++) {
			InventoryReceivingDetails newIRDetails = new InventoryReceivingDetails();
			newIRDetails.setInventoryReceiving(newInventoryReceiving);
			newIRDetails.setProductItem(productService.getProductById(productItems.get(i)));
			newIRDetails.setPrice(qtys.get(i));
			newIRDetails.setQty(prices.get(i));
			Session session1 = sessionFactory.openSession();
			Transaction t1 = session1.beginTransaction();
			try {
				session1.save(newIRDetails);
				t1.commit();
				System.out.println("done");
			} catch (Exception e) {
				t1.rollback();
				System.out.println(e);
			} finally {
				session1.close();
			}
			productService.updateQty(productItems.get(i), qtys.get(i));
		}
		return "admin/login";
	}

}
