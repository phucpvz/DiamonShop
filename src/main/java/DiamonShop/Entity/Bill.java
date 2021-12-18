package DiamonShop.Entity;

public class Bill {
	private long id;
	private String username;
	private String phone;
	private String display_name;
	private String address;
	private double total;
	private int quantity;
	private String note;

	public Bill() {
		super();
	}

	public Bill(long id, String username, String phone, String display_name, String address,
			double total, int quantity, String note) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.display_name = display_name;
		this.address = address;
		this.total = total;
		this.quantity = quantity;
		this.note = note;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
