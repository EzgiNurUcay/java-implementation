

public class Phone {
	private int countrycode;
	private int gsmcode;
	private int number;

	public int getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}

	public int getGsmcode() {
		return gsmcode;
	}

	public void setGsmcode(int gsmcode) {
		this.gsmcode = gsmcode;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Phone(int countrycode, int gsmcode, int number) {
		this.countrycode = countrycode;
		this.gsmcode = gsmcode;
		this.number = number;
	}

	public void display() {
		System.out.print("+" + countrycode + " " + gsmcode + " " + number + " ");
	}
}
