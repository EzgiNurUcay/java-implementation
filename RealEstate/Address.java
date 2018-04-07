
public class Address {
	private String street, city, district, apartno, homeno;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getApartno() {
		return apartno;
	}

	public void setApartno(String apartno) {
		this.apartno = apartno;
	}

	public String getHomeno() {
		return homeno;
	}

	public void setHomeno(String homeno) {
		this.homeno = homeno;
	}

	public Address(String street, String apartno, String homeno, String city, String district) {
		this.street = street;
		this.apartno = apartno;
		this.homeno = homeno;
		this.city = city;
		this.district = district;
	}
	public void display() {
		System.out.print(street+" "+apartno+" "+homeno+" "+city+" "+district+" ");
	}
}
