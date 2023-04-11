package ptithcm.service;

import java.awt.print.Printable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.payment.PaymentDao;
import ptithcm.model.pay.CustomerPaymentMethod;
import ptithcm.model.ship.ShippingMethod;


@Service
public class PaymentService {
	@Autowired
	private PaymentDao paymentDao;
	public List<CustomerPaymentMethod> getPaymentListById(int ctmID){
		List<CustomerPaymentMethod> listPayment = paymentDao.getPaymentListById(ctmID);
		if (listPayment== null) {
			return null;
		}
		return listPayment;
	};
	
	public List<ShippingMethod> getListShippingMethods() {
		List<ShippingMethod> listShippingMethods = paymentDao.getListShippingMethods();
		if (listShippingMethods == null) {
			return null;
		}
		return listShippingMethods;
	}
	
}
