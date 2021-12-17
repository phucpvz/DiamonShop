package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductDao;
import DiamonShop.Dto.ProductDto;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ProductDao productDao;
	
	public List<ProductDto> getProductsByIDCategory(int id) {
		return productDao.getProductsByIDCategory(id);
	}
	
	public List<ProductDto> getProductsPagination(int id, int start, int limit) {
		return productDao.getProductsPagination(id, start, limit);
	}
	
}
