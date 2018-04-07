

public class Company {

	private String name;
	public Shop[] shop= new Shop[5];
	private static int shopscount=0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		
	}
	
	public Company(String name) {
		
		this.name = name;
	

	}
	public void addShops(String shopcity){
		shop[shopscount] = new Shop(shopcity);
		shopscount++;
	}


	

}
