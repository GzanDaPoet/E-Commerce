package ptithcm.service;

import java.awt.print.Printable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.shoppingCart.ShoppingCartDao;
import ptithcm.model.shoppingCart.ShoppingCart;
import ptithcm.model.shoppingCart.ShoppingCartItem;
import ptithcm.model.address.Address;


@Service
public class CartService {
	@Autowired
	private ShoppingCartDao shoppingCartDao;
	public List<ShoppingCart> dsCart(){
		List<ShoppingCart> listCarts = shoppingCartDao.dsCart();
		if (listCarts == null) {
			return null;
		}
		return listCarts;
	};
	
	public List<ShoppingCartItem> getAllCartItemsById(int cartId){
		List<ShoppingCartItem> listCartItems = shoppingCartDao.getAllCartItemsById(cartId);
		if (listCartItems == null) {
			return null;
		}
		return listCartItems;
	}
	
	
	
	
	
	
	
}
