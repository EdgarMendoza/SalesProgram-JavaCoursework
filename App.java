
public class App extends Product{

	//Private variables specific to subclass App
	private AppType gameType;
	private String developer;
	
	//Default constructor
	public App(){
		this("", 0.0, new Date(0,0,0), AppType.GAME, "");
	}
	
	//Overridden constructor
	public App(String t, double p, Date date, AppType a, String dev){
		super(t,p,date);
		setGameType(a);
		setDeveloper(dev);
	}
	
	//Set Methods
	public void setGameType(AppType a){
		gameType = a;
	}
	
	public void setDeveloper(String dev){
		developer = dev;
	}
	
	//Get Methods
	public AppType getGameType(){
		return gameType;
	}
	
	public String getDeveloper(){
		return developer;
	}
	
	//Overridden toString Method
	@Override
	public String toString(){
		return String.format("%s\n%s, %s", super.toString(), getDeveloper(), getGameType());
	}
	
}

//Enum Class for Specific App Types
enum AppType{
	GAME("Game"), PRODUCTIVITY("Productivity"), EDUCATION("Education");
	
	private String type;
	
	private AppType(String type){
		this.type = type;
	}
}