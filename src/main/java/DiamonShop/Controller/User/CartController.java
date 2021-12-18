package DiamonShop.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bill;
import DiamonShop.Entity.User;
import DiamonShop.Service.User.BillServiceImpl;
import DiamonShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService;
	
	@Autowired
	private BillServiceImpl billService;
	
	@RequestMapping(value = {"/gio-hang",})
	public ModelAndView index() {
		_mvShare.addObject("slides", _homeService.getDataSlide());
		_mvShare.addObject("categories", _homeService.getDataCategories());
		_mvShare.addObject("products", _homeService.getDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	@RequestMapping(value = {"/add-cart/{id}"})
	@SuppressWarnings("unchecked")
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cartService.addCart(id, cart); // cart = cartService.addCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantityCart", cartService.getTotalQuantity(cart));
		session.setAttribute("totalPriceCart", cartService.getTotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = {"/edit-cart/{id}/{quantity}"})
	@SuppressWarnings("unchecked")
	public String addCart(HttpServletRequest request, HttpSession session, @PathVariable long id, @PathVariable int quantity) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cartService.editCart(id, quantity, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantityCart", cartService.getTotalQuantity(cart));
		session.setAttribute("totalPriceCart", cartService.getTotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = {"/delete-cart/{id}"})
	@SuppressWarnings("unchecked")
	public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cartService.deleteCart(id, cart);
		session.setAttribute("cart", cart);
		session.setAttribute("totalQuantityCart", cartService.getTotalQuantity(cart));
		session.setAttribute("totalPriceCart", cartService.getTotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		Bill bill = new Bill();
		User loginInfo = (User)session.getAttribute("loginInfo");
		if (loginInfo != null) {
			bill.setAddress(loginInfo.getAddress());
			bill.setDisplay_name(loginInfo.getDisplay_name());
			bill.setUsername(loginInfo.getUsername());
		}
		_mvShare.addObject("bill", bill);
		return _mvShare;
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	@SuppressWarnings("unchecked")
	public String checkoutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bill bill) {
		bill.setQuantity(Integer.parseInt(session.getAttribute("totalQuantityCart").toString()));
		bill.setTotal(Double.parseDouble(session.getAttribute("totalPriceCart").toString()));
		if (billService.addBill(bill) > 0) {
			HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("cart");
			billService.addBillDetail(cart);
		}
		session.removeAttribute("cart");
		return "redirect:gio-hang";
	}
}
