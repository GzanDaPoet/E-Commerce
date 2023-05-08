package ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.shoppingCart.ShoppingCartDao;
import ptithcm.model.shoppingCart.ShoppingCart;
import ptithcm.model.shoppingCart.ShoppingCartItem;

@Service
public class ShoppingCartService {
	@Autowired 
	private ShoppingCartDao shoppingCartDao;
	
	public List<ShoppingCart> getAllShoppingCart() {
		List<ShoppingCart> shoppingCarts = shoppingCartDao.getAllShoppingCart();
		if (!shoppingCarts.isEmpty()) {
			return shoppingCarts;
		}
		return null;
	}
	
	
	public Integer isHaveCart(int customerId) {
		System.out.println("1");
		if (!getAllShoppingCart().isEmpty())
		{
			for (ShoppingCart s: getAllShoppingCart()) {
				if (s.getCustomer().getId() == customerId) {
					return s.getId();
				}
			}
		}
		return 0;
	}
	
	public ShoppingCart getShoppingCartId(int cartId, int customerId) {
		if (isHaveCart(customerId) > 0 && getAllShoppingCart().size() > 0) {
			for (ShoppingCart s: getAllShoppingCart()) {
				if (s.getId() == cartId) {
					return s;
				}
			}
		}
		return null;
	}
	
	public List<ShoppingCartItem> getAllCartItemsById(int cartId) {
		List<ShoppingCartItem> list = shoppingCartDao.getAllCartItemsById(cartId);
		if (!list.isEmpty()) {
			return list;
		}
		return null;
	}

	public int getTotalQuantityOrdered(int cartId) {
		int sum = 0;
		List<ShoppingCartItem> list = getAllCartItemsById(cartId);
		System.out.println("Qua day");
		if (list.size() == 0) {
			System.out.println("List is empty");
			return 0;
		}
		else {
			System.out.println("List isn't empty");
			for (ShoppingCartItem s: list) {
				sum += s.getQuantity();
			}
		}
		return sum;
	}

}
