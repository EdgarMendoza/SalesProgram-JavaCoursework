//Abstract class that will be extended by Music and App classes
public abstract class Product {

	//Private variables common to all products
	private String title;
	private double price;
	private Date purchaseDate;
	
	//Default Constructor
	public Product(){
		this("", 0.0, new Date(0,0,0));
	}
	
	//Overloaded constructor
	public Product(String t, double p, Date date){
		
		setTitle(t);
		setPrice(p);
		setPurchaseDate(date);
	}
	
	//Set methods
	public void setTitle(String t){
		title = t;
	}
	
	public void setPrice(double p){
		price = p;
	}
	
	public void setPurchaseDate(Date date){
		purchaseDate = date;
	}
	
	//Get Methods
	public String getTitle(){
		return title;
	}
	
	public double getPrice(){
		return price;
	}
	
	public Date getPurchaseDate(){
		return purchaseDate;
	}
	
	//Overridden toString method
	@Override
	public String toString(){
		return String.format("%s, %d (%s)", getTitle(), getPrice(), getPurchaseDate());
	}
}
