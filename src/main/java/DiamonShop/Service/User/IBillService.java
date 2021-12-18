package DiamonShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bill;

@Service
public interface IBillService {
	public int addBill(Bill bill);
	public void addBillDetail(HashMap<Long, CartDto> cart);
}
