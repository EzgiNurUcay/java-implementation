

public class RealEstate {
	private int roomnumber, area;
	private double price;
	private String city, type, ID,sellorrent;

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {	this.roomnumber = roomnumber;}

	public int getArea() {return area;}

	public void setArea(int area) {this.area = area;}

	public String getCity() {return city;}

	public void setCity(String city) {this.city = city;}

	public String getType() {return type;}

	public void setType(String type) {this.type = type;}

	public String getID() {return ID;}

	public void setID(String iD) {ID = iD;}

	public String getSellorrent() {return sellorrent;}

	public void setSellorrent(String sellorrent) {
		this.sellorrent = sellorrent;
	}

	public RealEstate(String ID,String type,String sellorrent,int roomnumber, int area, String city,double price ) {
		this.sellorrent=sellorrent;
		this.roomnumber = roomnumber;
		this.area = area;
		this.city = city;
		this.type = type;
		this.ID = ID;
		this.price=price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public void display(){
		
		System.out.println(ID+"   " +type+"   "+area+"    "+roomnumber+"  "+ city+"   "+ price);
	}
}
