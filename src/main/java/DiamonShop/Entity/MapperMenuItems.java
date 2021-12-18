package DiamonShop.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperMenuItems implements RowMapper<MenuItem> {

	public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuItem item = new MenuItem();
		item.setId(rs.getInt("id"));
		item.setName(rs.getString("name"));
		item.setUrl(rs.getString("url"));
		return item;
	}
}
