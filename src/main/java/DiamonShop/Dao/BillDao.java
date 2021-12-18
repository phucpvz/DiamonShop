package DiamonShop.Dao;

import org.springframework.stereotype.Repository;

import DiamonShop.Entity.Bill;
import DiamonShop.Entity.BillDetail;

@Repository
public class BillDao extends BaseDao {
	
	public int addBill(Bill bill) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO bills ");
		sql.append("( ");
		sql.append(" username, phone, display_name, address, total, quantity, note ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append(" '" + bill.getUsername() + "', ");
		sql.append(" '" + bill.getPhone() + "', ");
		sql.append(" '" + bill.getDisplay_name() + "', ");
		sql.append(" '" + bill.getAddress() + "', ");
		sql.append(" " + bill.getTotal() + ", ");
		sql.append(" " + bill.getQuantity() + ", ");
		sql.append(" '" + bill.getNote() + "' ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public long getIDLastBill() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	}
	
	public int addBillDetail(BillDetail billDetail) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO billdetails ");
		sql.append("( ");
		sql.append(" id_product, id_bill, quantity, total ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append(" " + billDetail.getId_product()+ ", ");
		sql.append(" " + billDetail.getId_bill()+ ", ");
		sql.append(" " + billDetail.getQuantity()+ ", ");
		sql.append(" " + billDetail.getTotal()+ " ");
		sql.append(")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
}
