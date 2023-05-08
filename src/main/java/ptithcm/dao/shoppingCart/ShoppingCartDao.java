
package ptithcm.dao.shoppingCart;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.model.shoppingCart.*;


@Service
public interface ShoppingCartDao {
	public List<ShoppingCartItem> getAllCartItemsById(int cmtId);
	public List<ShoppingCart> getAllShoppingCart();
	public int deleteCartItem(int idCartItem);
	public int increaseQty( int shoppingCartItemId); 
	public int decreaseQty( int shoppingCartItemId);	
}