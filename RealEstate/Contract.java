

public class Contract {
	Customer customer;
	private String contractnum, saleorrent;
	private double price;
	RealEstate re;
	Date contractdate;

	

	public String getContractnum() {
		return contractnum;
	}

	public void setContractnum(String contractnum) {
		this.contractnum = contractnum;
	}

	public String getSaleorrent() {
		return saleorrent;
	}

	public void setSaleorrent(String saleorrent) {
		this.saleorrent = saleorrent;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	public Contract(Customer customer, String contractnum, RealEstate re, Date contractdate, String saleorrent,
			double price) {
		this.customer = customer;
		this.contractnum = contractnum;
		this.re = re;
		this.contractdate = contractdate;
		this.saleorrent = saleorrent;
		this.price = price;
	}

	public void display(Contract contr) {
		System.out.println(contr.customer.getCustomerID() + "         " + contr.re.getID() + "          "
				+ contractdate.getDay() + "." + contractdate.getMonth() + "." + contractdate.getYear() + "    "
				+ getSaleorrent() + "    " + getPrice());
	}
}
