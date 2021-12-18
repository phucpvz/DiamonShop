package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DiamonShop.Entity.MapperSlides;
import DiamonShop.Entity.Slide;

@Repository
public class SlideDao extends BaseDao {

	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	public List<Slide> getDataSlide() {
		List<Slide> list = new ArrayList<Slide>();
		String sql = "SELECT * FROM slides";
		list = _jdbcTemplate.query(sql, new MapperSlides());
		return list;
	}
}
