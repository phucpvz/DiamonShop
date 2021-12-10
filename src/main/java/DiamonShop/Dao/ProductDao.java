package DiamonShop.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import DiamonShop.Dto.ProductDto;
import DiamonShop.Dto.ProductDtoMapper;

@Repository
public class ProductDao extends BaseDao {

	@Autowired
	public JdbcTemplate _jdbcTemplate;

	private StringBuffer getSqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.sizes ");
		sql.append(", p.name ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.details ");
		sql.append(", c.id as id_color ");
		sql.append(", c.name as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", c.img ");
		sql.append(", p.created_at ");
		sql.append(", p.updated_at ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("colors AS c ");
		sql.append("ON p.id = c.id_product ");
		return sql;
	}
	
	private String getSqlProducts(boolean newProduct, boolean highlight) {
		StringBuffer sql = getSqlString();
		sql.append("WHERE 1=1 ");
		if (newProduct) {
			sql.append("AND p.new_product = true ");
		}
		if (highlight) {
			sql.append("AND p.highlight = true ");
		}
		
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		
		if (newProduct) {
			sql.append("LIMIT 12 ");
		}
		if (highlight) {
			sql.append("LIMIT 9 ");
		} 
		return sql.toString();
	}

	public List<ProductDto> getDataProducts() {
		List<ProductDto> list = new ArrayList<ProductDto>();
		list = _jdbcTemplate.query(getSqlProducts(false, true), new ProductDtoMapper());
		return list;
	}
}