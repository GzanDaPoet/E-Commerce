package ptithcm.dao.user;

import ptithcm.model.user.User;

public interface UserDao {
	public User findByUserNameAndPasswordAndStatus(String userName, String password, boolean status);
	public User getUserById(int id);
}
