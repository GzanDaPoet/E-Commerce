
package ptithcm.dao.shoppingCart;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.model.shoppingCart.*;
import ptithcm.service.CartService;

@Service
public interface ShoppingCartDao {
	public List<ShoppingCart> dsCart();
	public List<ShoppingCartItem> getAllCartItemsById(int cartId);
}