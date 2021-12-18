package DiamonShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.UserDao;
import DiamonShop.Entity.User;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private UserDao userDao;

	public int addAccount(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return userDao.addAccount(user);
	}

	public User checkAccount(User user) {
		String pass = user.getPassword();
		user = userDao.getUserByAcc(user);
		if (user != null) {
			if (BCrypt.checkpw(pass, user.getPassword())) {
				return user;
			}
			else {
				return null;
			}
		}
		return null;
	}

	
}
