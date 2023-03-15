package ptithcm.dao;

import ptithcm.model.admin.User; 

public interface UserDao {
	public User findUserByName(String username);
}
