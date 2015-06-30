
public class Date {

	//Private variables
	private int day;
	private int month;
	private int year;
	
	//Default constructor
	public Date(){
		this(0,0,0);
	}
	
	//Overloaded constructor
	public Date(int d, int m, int y){
		setDay(d);
		setMonth(m);
		setYear(y);
	}
	
	//Set Methods
	public void setDay(int d){
		day = d;
	}
	
	public void setMonth(int m){
		month = m;
	}
	
	public void setYear(int y){
		year = y;
	}
	
	//Get Methods
	public int getDay(){
		return day;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getYear(){
		return year;
	}
	
	
	//Overridden toString method
	@Override
	public String toString(){
		return String.format("%02d/%02d/%04d", getMonth(), getDay(), getYear());
	}
}
