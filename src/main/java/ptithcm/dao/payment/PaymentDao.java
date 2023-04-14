package ptithcm.dao.payment;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.model.pay.CustomerPaymentMethod;
import ptithcm.model.ship.ShippingMethod;



@Service
public interface PaymentDao {
	public List<CustomerPaymentMethod> getPaymentListById(int ctmID);
	public List<ShippingMethod> getListShippingMethods();
	//public int checkOut();
}