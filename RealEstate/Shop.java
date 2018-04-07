
public class Shop {

	private String shopcity;
	public Salesman[] saleman = new Salesman[20]; //
	public Customer[] cust = new Customer[20];
	public RealEstate[] re = new RealEstate[20];
	public Contract[] contr = new Contract[20];

	private static int customernum; // To define count of customer.
	private static int contnum; // To define count of contract.
	private static int realestatenum; // To define count of real estate.
	private static int salesmannum; // To define count of salesman.

	public Shop(String shopcity) {
		this.shopcity = shopcity;
	}

	public String getShopcity() {
		return shopcity;
	}

	public void setShopcity(String shopcity) {
		this.shopcity = shopcity;
		customernum = 0;
		contnum = 0;
		realestatenum = 0;
		salesmannum = 0;
	}

	public static int getContnum() {
		return contnum;
	}

	public static void setContnum(int contnum) {
		Shop.contnum = contnum;
	}

	public static int getRealestatenum() {
		return realestatenum;
	}

	public static void setRealestatenum(int realestatenum) {
		Shop.realestatenum = realestatenum;
	}

	public static int getSalesmannum() {
		return salesmannum;
	}

	public static void setSalesmannum(int salesmannum) {
		Shop.salesmannum = salesmannum;
	}

	public static int getCustomernum() {
		return customernum;
	}

	public static void setCustomernum(int customernum) {
		Shop.customernum = customernum;
	}

	// Salesman is an inner class.

	public class Salesman {
		String name;
		Date smbirthday;
		Address smaddress;
		Phone smphone;
		double salary;

		public Salesman(String name, Date smbirthday, Address smaddress, Phone smphone) {
			this.name = name;
			this.smbirthday = smbirthday;
			this.smaddress = smaddress;
			this.smphone = smphone;
			this.salary = 1777.50;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getSmbirthday() {
			return smbirthday;
		}

		public void setSmbirthday(Date smbirthday) {
			this.smbirthday = smbirthday;
		}

		public Address getSmaddress() {
			return smaddress;
		}

		public void setSmaddress(Address smaddress) {
			this.smaddress = smaddress;
		}

		public Phone getSmphone() {
			return smphone;
		}

		public void setSmphone(Phone smphone) {
			this.smphone = smphone;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		public void display() {
			System.out.print(name + " ");
			smbirthday.display();
			smaddress.display();
			smphone.display();
			System.out.print(salary);
		}
	}

	public void addsalesman(String name, Date birthday, Address address, Phone phone) {

		saleman[salesmannum] = new Salesman(name, birthday, address, phone);
		salesmannum++;

	}

	public void addRealEstate(String ID, String type, String sell, int roomnum, int area, String city, int price) {

		re[realestatenum] = new RealEstate(ID, type, sell, roomnum, area, city, price);
		realestatenum++;
	}

	public void addCustomer(String customerID, String name, Address address, Phone phone, Date birthday) {

		cust[customernum] = new Customer(customerID, name, address, phone, birthday);
		customernum++;
	}
	
	public void addCustomer(Customer cust[]) {
		cust[customernum] = new Customer(cust[customernum].getCustomerID(), cust[customernum].getName(),
				cust[customernum].getAddress(), cust[customernum].getPhone());
		customernum++;
	}

	public void addContract(Customer customer, String contractnum, RealEstate re, Date contractdate, String saleorrent,
			double price) {
		contr[contnum] = new Contract(customer, contractnum, re, contractdate, saleorrent, price);
		contnum++;
	}

	public void listSalesman(Salesman sm[]) {
		for (int i = 0; i < salesmannum; i++) {
			sm[i].display();
		}
		System.out.println();
	}

	public void listContract(Contract contr[]) {
		System.out.println("CustomerID   RealEstateID   Date         Type    Price   ");
		for (int i = 0; i < contnum; i++) {
			contr[i].display(contr[i]);
		}
		System.out.println();
	}

	public void listRealEstate(RealEstate re[]) {
		System.out.println("ID       Type       Area  Room    City      Price");
		for (int i = 0; i < realestatenum; i++) {
			re[i].display();
		}
		System.out.println();
	}

	public void listCustomer(Customer cust[]) {
		for (int i = 0; i < customernum; i++) {
			System.out.println(cust[i].getName());
		}
	}

	public void increase(RealEstate re[]) {
		double newprice;
		for (int i = 0; i < realestatenum; i++) {
			newprice = re[i].getPrice() + re[i].getPrice() * 0.01;
			re[i].setPrice(newprice);
			contr[i].setPrice(newprice); // To effect contract prize.
		}

	}

	public void calculatecommission(Contract contr[]) {
		double result = 0;

		for (int i = 0; i < contnum; i++) {

			if (contr[i].getSaleorrent().equals("sale")) // %5 commissions from
															// each sale and one
															// month's rent from
															// each rental.
			{
				result += contr[i].getPrice() * 0.05;
			} else
				result += contr[i].getPrice();

		}
		System.out.println(result);

	}

}
