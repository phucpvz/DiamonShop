package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Category;
import DiamonShop.Entity.CategoryMapper;

@Repository
public class CategoryDao extends BaseDao {
	
	public List<Category> getDataCategories() {
		List<Category> list = new ArrayList<Category>();
		String sql = "SELECT * FROM categories";
		list = _jdbcTemplate.query(sql, new CategoryMapper());
		return list;
	}
}
