import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AppReader {


	//Scanner to read the input from file
	private Scanner input;
	
	//Method to open the file
	public void openAppFile(){
		try{
			input = new Scanner( new File("app.txt"));
		} catch (FileNotFoundException fileNotFoundException){
			System.err.println("Error opening files");
			System.exit(1);
		}
	}
	
	//Method to create an app if the title is found in the File
	public App searchFile(String search, Date da, AppType a){
		
		App app = new App();
		
		try{
			while (input.hasNext()){
				
				//Reads the first line to compare it to the title given
				String next = input.nextLine();
				
				//Fills app if correct
				if(search.equals(next)){
					app.setTitle(next);
					app.setDeveloper(input.nextLine());
					app.setPrice(input.nextDouble());
					app.setPurchaseDate(da);
					app.setGameType(a);

					return app;
				}
				
			
			}
			
			//Catching things that don't work
		} catch(NoSuchElementException elementException){
			System.err.println("File improperly formed.");
			input.close();
			System.exit(1);
		}catch (IllegalStateException stateException){
			System.err.println("Error reading from file.");
			System.exit(1);
		}
		
		//Returns a null value if the app isn't created to be ignored later
		return null;
	}
	
	//Close the file
	public void closeAppFile(){
		if (input != null)
			input.close();
	}
}
