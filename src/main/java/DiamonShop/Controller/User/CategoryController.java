package DiamonShop.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.PaginationDto;
import DiamonShop.Service.User.CategoryServiceImpl;
import DiamonShop.Service.User.PaginationServiceImpl;

@Controller
public class CategoryController extends BaseController {
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired
	private PaginationServiceImpl paginationService;
	
	private int limit = 9;
	
	@RequestMapping(value = {"/san-pham/{id}"})
	public ModelAndView product(@PathVariable int id) {
		int totalData = categoryService.getProductsByIDCategory(id).size();
		PaginationDto pagination = paginationService.getInfoPagination(totalData, limit, 1);
		_mvShare.setViewName("user/products/category");
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("pagination", pagination);
		_mvShare.addObject("productsPagination", categoryService.getProductsPagination(id, pagination.getStart(), limit));
		return _mvShare;
	}
	
	@RequestMapping(value = {"/san-pham/{id}/{currentPage}"})
	public ModelAndView product(@PathVariable int id, @PathVariable int currentPage) {
		int totalData = categoryService.getProductsByIDCategory(id).size();
		PaginationDto pagination = paginationService.getInfoPagination(totalData, limit, currentPage);
		_mvShare.setViewName("user/products/category");
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("pagination", pagination);
		_mvShare.addObject("productsPagination", categoryService.getProductsPagination(id, pagination.getStart(), limit));
		return _mvShare;
	}
}
