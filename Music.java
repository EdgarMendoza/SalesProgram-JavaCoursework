
public class Music extends Product {

	//Private variables
	private GenreType genre;
	private String artist;
	private int numberOfSongsPurchased;
	
	//Default constructor
	public Music(){
		this("", 0.0, new Date(0,0,0), GenreType.ROCK, "", 0);
	}
	
	//Overloaded constructor
	public Music(String t, Double p, Date d, GenreType g, String a, int n){
		super(t, p, d);
		setGenre(g);
		setArtist(a);
		setNumberOfSongsPurchased(n);
		
	}
	
	//Set methods
	public void setGenre(GenreType g){
		genre = g;
	}
	
	public void setArtist(String a){
		artist = a;
	}
	
	public void setNumberOfSongsPurchased(int n){
		numberOfSongsPurchased = n;
	}

	//Get Methods
	public GenreType getGenre(){
		return genre;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public int getNumberOfSongsPurchased(){
		return numberOfSongsPurchased;
	}
	
	//Overridden getPrice method to return the value (given per song) times the number of songs
	//purchased by the user.
	@Override
	public double getPrice(){
		return super.getPrice()*getNumberOfSongsPurchased();
	}
	
	//Overridden toString method
	@Override
	public String toString(){
		return String.format("%s\n%s %s %d", super.toString(), getArtist(), getGenre(), getNumberOfSongsPurchased());
	}
}

//Enum class for specific Genre types for the music
enum GenreType{
	
	CLASSICAL("Classical"), ROCK("Rock"), COUNTRY("Country");

	GenreType(String type){
		
	}
	
}
