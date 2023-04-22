package ptithcm.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.user.UserDao;
import ptithcm.model.user.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public User findByUserNameAndPasswordAndStatus(String userName, String password, boolean status) {
		return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
}
