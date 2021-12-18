package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperUsers;
import DiamonShop.Entity.User;

@Repository
public class UserDao extends BaseDao {
	
	public int addAccount(User user) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO users ");
		sql.append("( ");
		sql.append(" username, ");
		sql.append(" password, ");
		sql.append(" display_name, ");
		sql.append(" address ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append(" '" + user.getUsername() + "', ");
		sql.append(" '" + user.getPassword() + "', ");
		sql.append(" '" + user.getDisplay_name() + "', ");
		sql.append(" '" + user.getAddress() + "' ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public User getUserByAcc(User user) {
		String sql = "SELECT * FROM users WHERE username = '" + user.getUsername() + "'";
		User result = _jdbcTemplate.queryForObject(sql, new MapperUsers());
		return result;
	}
}
