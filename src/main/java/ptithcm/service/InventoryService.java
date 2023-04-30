package ptithcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.inventory.InventoryDao;
import ptithcm.dao.user.UserDao;
import ptithcm.model.inventory.StatusReceiving;
import ptithcm.model.user.User;

@Service 
public class InventoryService {
	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	private UserDao userDao;
	
	public List<StatusReceiving> getAllStatusReceivings() {
		List<StatusReceiving> listStatus = inventoryDao.getAllStatusReceivings();
		if (listStatus == null) {
			return null;
		}
		return listStatus;
	}
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
}