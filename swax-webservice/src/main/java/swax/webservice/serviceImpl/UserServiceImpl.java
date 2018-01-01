package swax.webservice.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import swax.webservice.dao.IUserDAO;
import swax.webservice.entity.User;
import swax.webservice.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{
	
	@Resource(name = "userDAO")
	private IUserDAO userDAO = null;

	@Override
	public List<User> findAll() {
		return this.userDAO.findAll();
	}

	@Override
	public Integer createUpdateEntity(User user) {
		return this.userDAO.saveAndFlush(user).getUserId();
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.findByEmail(email);
	}

}
