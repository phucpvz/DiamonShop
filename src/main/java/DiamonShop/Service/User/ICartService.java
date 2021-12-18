package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.CartDto;

@Service
public interface ICartService {
	public HashMap<Long, CartDto> addCart(long id, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> editCart(long id, int quantity, HashMap<Long, CartDto> cart);
	public HashMap<Long, CartDto> deleteCart(long id, HashMap<Long, CartDto> cart);
	public int getTotalQuantity(HashMap<Long, CartDto> cart);
	public int getTotalPrice(HashMap<Long, CartDto> cart);
}
