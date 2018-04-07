
 /*
 * Companys have some shops and all shops have salesman.
 * So salesman is a inner class because directly related to shop class.
 * Shops manage add customer or real estate so I would like to write function and methods in shops class.
 */

public class Test {

	public static void main(String[] args) {

		Company cmp = new Company("DeuEmlak"); //The company is created.
        cmp.addShops("IZMIR");  // Added one shop in �zmir.
		Date birthday = new Date(27, 03, 1982);  // Created birthday, phonenumber and adr for salesman.
		Phone phonenumber = new Phone(90, 555, 234567); 
		Address adr = new Address("Ata cad.", "27", "15", "IZMIR", "ANKAYA");
		cmp.shop[0].addsalesman("Ali TAS", birthday, adr, phonenumber); // The salesman is created.

		cmp.shop[0].addRealEstate("RE001", "apartment", "rent", 3, 120, "    Izmir  ", 900); // Four real estates is added and one extra.
		cmp.shop[0].addRealEstate("RE002", "triplex  ", "sale", 7, 200, "    Izmir  ", 200000);
		cmp.shop[0].addRealEstate("RE003", "office   ", "rent", 2, 105, "    Izmir  ", 1000);
		cmp.shop[0].addRealEstate("RE004", "apartment", "rent", 4, 100, "    Izmir  ", 1100);
			
		// Four customers is added.
		Date birthd = new Date(12, 06, 1984);
		Phone pnumber = new Phone(90, 232, 7654321);
		Address address = new Address("Sanayi cad.", "45", "10", "IZMIR", "KARSIYAKA");
		cmp.shop[0].addCustomer("C001", "Can AK", address, pnumber, birthd); 

		Date birthday1 = new Date(18, 03, 1992);
		Phone pnumber1 = new Phone(90, 535, 8756945);
		Address adr1 = new Address("Cumhuriyet cad.", "30", "12", "IZMIR", "BALCOVA");
		cmp.shop[0].addCustomer("C002", "Veli CANDAN", adr1, pnumber1, birthday1);

		Date birthday2 = new Date(18, 05, 1990);
		Phone pnumber2 = new Phone(90, 544, 7625306);
		Address adr2 = new Address("Atat�rk cad.", "30", "12", "IZMIR", "BOSTANLI");
		cmp.shop[0].addCustomer("C003", "Ay�e BO�NAK", adr2, pnumber2, birthday2);
		
		
		Phone pnumber3 = new Phone(90, 505, 5553344);
		Address adr3 = new Address("35 cad.", "30", "12", "IZMIR", "UCYOL");
		cmp.shop[0].cust[3] = new Customer("C004","Aylin SAYGIN",adr3,pnumber3); 
		// To different way create customer, if any customer don't want to give birthday.
	  
	 
		
		// Three contracts is added.
		Date contractdate = new Date(18, 2, 2017);
		Date contractdate1 = new Date(15, 2, 2017);
		Date contractdate2 = new Date(27, 2, 2017);
		Date contractdate3 = new Date(17, 2, 2017);
		
		cmp.shop[0].addContract(cmp.shop[0].cust[0], "RE001", cmp.shop[0].re[0], contractdate, cmp.shop[0].re[0].getSellorrent(), cmp.shop[0].re[0].getPrice());
		cmp.shop[0].addContract(cmp.shop[0].cust[1], "RE002", cmp.shop[0].re[1], contractdate1,cmp.shop[0].re[1].getSellorrent(), cmp.shop[0].re[1].getPrice());
		cmp.shop[0].addContract(cmp.shop[0].cust[2], "RE003", cmp.shop[0].re[2], contractdate2, cmp.shop[0].re[2].getSellorrent(), cmp.shop[0].re[2].getPrice());
		cmp.shop[0].addContract(cmp.shop[0].cust[3],"RE004", cmp.shop[0].re[3], contractdate3,cmp.shop[0].re[3].getSellorrent(),cmp.shop[0].re[3].getPrice()); 
		
		//-------
		
		// To print all real estates . 
		cmp.shop[0].listRealEstate(cmp.shop[0].re);
		cmp.shop[0].listContract(cmp.shop[0].contr);
		
		// Increase the prices of all real estates by %10 by using set method and print again.
		cmp.shop[0].increase(cmp.shop[0].re);
		cmp.shop[0].listRealEstate(cmp.shop[0].re);
		
		//Contracts and salesman information.
		cmp.shop[0].listContract(cmp.shop[0].contr);
		cmp.shop[0].calculatecommission(cmp.shop[0].contr);
	   // Extras.
	   //cmp.shop[0].listSalesman(cmp.shop[0].saleman);
	   //cmp.shop[0].listCustomer(cmp.shop[0].cust);
	}

}
