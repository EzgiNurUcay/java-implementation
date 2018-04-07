
// Customer have extra constructor. For customer who don't want to share birthday.
public class Customer {
	private String customerID, name;
	Address address;
	Phone phone;
	Date birthday;
	RealEstate re; // To define one more constructor.

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public RealEstate getRe() {
		return re;
	}

	public void setRe(RealEstate re) {
		this.re = re;
	}

	public Customer(String customerID, String name, Address address, Phone phone, Date birthday) {
		this.customerID = customerID;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.birthday = birthday;

	}
	public Customer(String customerID, String name, Address address, Phone phone)
	{
		this.customerID = customerID;
	this.name = name;
	this.address = address;
	this.phone = phone;
	}

}
