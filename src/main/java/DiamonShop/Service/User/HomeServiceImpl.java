package DiamonShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.CategoryDao;
import DiamonShop.Dao.MenuItemDao;
import DiamonShop.Dao.ProductDao;
import DiamonShop.Dao.SlideDao;
import DiamonShop.Dto.ProductDto;
import DiamonShop.Entity.Category;
import DiamonShop.Entity.MenuItem;
import DiamonShop.Entity.Slide;

@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private SlideDao slidesDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private MenuItemDao menuItemDao;
	@Autowired
	private ProductDao productDao;
	
	public List<Slide> getDataSlide() {
		return slidesDao.getDataSlide();
	}

	public List<Category> getDataCategories() {
		return categoryDao.getDataCategories();
	}
	
	public List<MenuItem> getDataMenuItems() {
		return menuItemDao.getDataMenuItems();
	}
	
	public List<ProductDto> getDataProducts() {
		return productDao.getDataProducts();
	}
}
