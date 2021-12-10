package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductDto;
import DiamonShop.Entity.Category;
import DiamonShop.Entity.MenuItem;
import DiamonShop.Entity.Slide;

@Service
public interface IHomeService {
	@Autowired
	public List<Slide> getDataSlide();
	public List<Category> getDataCategories();
	public List<MenuItem> getDataMenuItems();
	public List<ProductDto> getDataProducts();
}
