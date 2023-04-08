package ptithcm.dao.shoppingCart;

import java.util.List;

import ptithcm.model.shoppingCart.ShoppingCart;
import ptithcm.model.shoppingCart.ShoppingCartItem;


public interface ShoppingCartDao {
	public List<ShoppingCart> getAllShoppingCart();
	public List<ShoppingCartItem> getAllCartItemsById(int cartId);
}
