package DiamonShop.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.BillDao;
import DiamonShop.Dto.CartDto;
import DiamonShop.Entity.Bill;
import DiamonShop.Entity.BillDetail;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	private BillDao billDao;

	public int addBill(Bill bill) {
		return billDao.addBill(bill);
	}

	public void addBillDetail(HashMap<Long, CartDto> cart) {
		long idBill = billDao.getIDLastBill();
		for (Map.Entry<Long, CartDto> itemCart : cart.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bill(idBill);
			billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billDetail.setQuantity(itemCart.getValue().getQuantity());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billDao.addBillDetail(billDetail);
		}
	}
}
