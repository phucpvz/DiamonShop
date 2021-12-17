package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.ProductDao;
import DiamonShop.Dto.ProductDto;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductDao productDao;
	
	public ProductDto getProductByID(long id) {
		return productDao.getProductByID(id).get(0);
	}

	public List<ProductDto> getProductsByIDCategory(int id) {
		return productDao.getProductsByIDCategory(id);
	}

}
