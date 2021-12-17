package DiamonShop.Controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.ProductDto;
import DiamonShop.Service.User.IProductService;

@Controller
public class ProductController extends BaseController {
	
	@Autowired
	IProductService _productService;
	
	@RequestMapping(value = {"/chi-tiet-san-pham/{id}"})
	public ModelAndView index(@PathVariable long id) {
		ProductDto product = _productService.getProductByID(id);
		List<ProductDto> listProducts = _productService.getProductsByIDCategory(product.getId_category());
		_mvShare.addObject("product", product);
		_mvShare.addObject("productsByIDCategory", listProducts);
		_mvShare.setViewName("user/products/product");
		return _mvShare;
	}
}
