
import java.util.ArrayList;
public class Customer implements PurchaseHistory {

	//Private variables for each customer
	private String name;
	private Address address;
	private int accountNumber;
	private ArrayList<Product> productList = new ArrayList<Product>();

	//Default constructor
	public Customer(){
		this("", new Address(), 0);
	}
	
	//Overloaded constructor
	public Customer(String n, Address a, int num){
		setName(n);
		setAddress(a);
		setAccountNumber(num);
	}
	
	//Set Methods
	public void setName(String n){
		name = n;
	}
	
	public void setAddress(Address a){
		address = a;
	}
	
	public void setAccountNumber(int n){
		accountNumber = n;
	}
	
	//Get Methods
	public String getName(){
		return name;
	}
	
	public Address getAddress(){
		return address;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	//Overloaded toString Method
	@Override
	public String toString(){
		return String.format("%s\n%s\n%d\n%s", getName(), getAddress(), getAccountNumber(), createHistory());
	}
	
	//Implemented version of CreateHistory method
	@Override
	public String createHistory() {
		
		//Variables to hold count of each type of product for individual totals
		int musicCount = 0;
		int appCount = 0;
		
		//Enhanced for loop that matches each product with it's correct subclass type
		for(Product p : productList){
			if (p instanceof Music)
				musicCount++;
			else if (p instanceof App)
				appCount++;
		}
		//Returns the customer name, counts for music and apps purchased and total charge
		return String.format("%s %d %s %d %s $%.2f", getName(), musicCount, "Music Products",
				appCount, "App Products", calculateCharge());
	}

	//Method to add products to the ArrayList
	public void addToProductList(Product p){
		productList.add(p);
	}
	
	//Method to calculate total charge
	public double calculateCharge(){
		//Double value to hold ongoing total
		double total = 0;
		
		//Enhanced for loop to add all prices to total
		for(Product p : productList){
			total += p.getPrice();
		}
		return total;
	}
}
