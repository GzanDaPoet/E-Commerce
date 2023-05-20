package ptithcm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptithcm.dao.user.UserDao;
import ptithcm.model.customer.CustomerAddress;
import ptithcm.model.user.User;
import ptithcm.model.user.UserPermission;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public User findByUserNameAndPasswordAndStatus(String userName, String password, boolean status) {
		return userDao.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
	
	public  List<UserPermission> getListUserPermissions(){
		List<UserPermission> permissionList = userDao.getListPermissions();
		if (permissionList == null) {
			return null;
		}
		return permissionList;
	}
	
	public UserPermission getPermissionById(int id) {
		return userDao.getPermissionbyId(id);
	}
}
