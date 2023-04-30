package ptithcm.dao.inventory;

import java.util.List;


import ptithcm.model.inventory.StatusReceiving;

public interface InventoryDao {
	public List<StatusReceiving> getAllStatusReceivings();
}
