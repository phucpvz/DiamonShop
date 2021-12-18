package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperMenuItems;
import DiamonShop.Entity.MenuItem;

@Repository
public class MenuItemDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	public List<MenuItem> getDataMenuItems() {
		List<MenuItem> list = new ArrayList<MenuItem>();
		String sql = "SELECT * FROM menuitems";
		list = _jdbcTemplate.query(sql, new MapperMenuItems());
		return list;
	}
}
