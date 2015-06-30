import java.util.ArrayList;
import javax.swing.JFrame;
public class Sales {

	//Static ArrayList of customers to hold however many customers we want
	public static ArrayList<Customer> customerList;
	
	public static void main(String[] args){
		
		//Create the GUI and give it some dimensions
		SalesGUI gui = new SalesGUI();
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(800, 390);
		gui.setVisible(true);
		
		
		//Instantiate the list of customers
		customerList = new ArrayList<Customer>();
		
		
	}
	
	//Method to add a new customer to the list
	public static void createCustomer(Customer c){
		
		customerList.add(c);
	}
	
	//Method to check to see if the customer is already an existing customer based upon name
	public static int checkCustomerList(String name){
		
		//Create index variable to return location of customer
		//Start index at -1, if customer doesn't exist
		//this will indicate a need to create a customer
		int index = -1;
		
		//Cycle through the loop
		for(Customer c: customerList){
		
			//If customer name matches, get the index of that customer
			if(name.equalsIgnoreCase(c.getName())){
				index = customerList.indexOf(c);
			}
		}
		
		//Return customer index
		return index;
	}
	
	//Method to add a purchase to the user in the specific index
	public static void addPurchase(int index, Product p){
		
		customerList.get(index).addToProductList(p);
	}
	
	 
}//End of Sales class