package ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.shoppingCart.ShoppingCartDao;
import ptithcm.model.product.ProductItem;
import ptithcm.model.shoppingCart.ShoppingCart;
import ptithcm.model.shoppingCart.ShoppingCartItem;

@Service
public class ShoppingCartService {
	@Autowired 
	private ShoppingCartDao shoppingCartDao;
	
	public List<ShoppingCart> getAllShoppingCart() {
		List<ShoppingCart> shoppingCarts = null;
		shoppingCarts =  shoppingCartDao.getAllShoppingCart();
		System.out.println(shoppingCarts.size());
		if (shoppingCarts.size() > 0) {
			return shoppingCarts;
		}
		return null;
	}
	
	
	public int isHaveCart(int customerId) {
	
		if (getAllShoppingCart().size() > 0)
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
	
	public List<ShoppingCartItem> getAllCartItemsById(int customerId) {
		List<ShoppingCartItem> list = shoppingCartDao.getAllCartItemsById(customerId);
		if (!list.isEmpty()) {
			return list;
		}
		return null;
	}

	public int getTotalQuantityOrdered(int customerId) {
		int sum = 0;
		List<ShoppingCartItem> listCartItem = shoppingCartDao.getAllCartItemsById(customerId);
		if (listCartItem.size() == 0) {
			System.out.println("NULLLLL");
			return 0;
		}
		else {
			for (ShoppingCartItem s: listCartItem) {
				sum += s.getQuantity();
			}
		}
		return sum;
	}
	
	public boolean isAddedToCart(int productId, int cartId) {
		for (ShoppingCartItem productItem: getAllCartItemsById(cartId)) {
			if (productId == productItem.getProductItem().getId()) {
				return true;
			}
		}
		return false;
	}

}
