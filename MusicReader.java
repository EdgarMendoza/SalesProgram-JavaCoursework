import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MusicReader {


	//Scanner to read the file
	private Scanner input;
	
	
	//Opening the music File
	public void openMusicFile(){
		try{
			input = new Scanner( new File("music.txt"));
		} catch (FileNotFoundException fileNotFoundException){
			System.err.println("Error opening files");
			System.exit(1);
		}
	}
	
	//Method to create a music item if the title matches
	public Music searchFile(String search, Date da , GenreType g){
		
		Music music = new Music();
		
		
		
		try{
			while (input.hasNext()){
				
				String next = input.nextLine();
				
				//Compare the title criteria to the items in the txt file
				if(search.equals(next)){
					music.setTitle(next);
					music.setArtist(input.nextLine());
					music.setNumberOfSongsPurchased(input.nextInt());
					music.setPrice(input.nextDouble());
					music.setPurchaseDate(da);
					music.setGenre(g);
					
					//Return if matching
					return music;
				}
				
			
			}
			
			//Catching errors
		} catch(NoSuchElementException elementException){
			System.err.println("File improperly formed.");
			input.close();
			System.exit(1);
		}catch (IllegalStateException stateException){
			System.err.println("Error reading from file.");
			System.exit(1);
		}
		
		//Return a null value to be disregarded if the name doesn't match
		return null;
	}
	
	//Close the file
	public void closeMusicFile(){
		if (input != null)
			input.close();
	}
}
