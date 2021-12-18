package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Entity.User;

@Service
public interface IAccountService {
	public int addAccount(User user);
	public User checkAccount(User user);
}
