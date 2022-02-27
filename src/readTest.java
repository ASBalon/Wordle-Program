import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class readTest {
	public static void main(String[] args) {
		filereader();
	}
	
	public static void filereader ()
	{
		try
		{
			Scanner fileScanner = new Scanner(new File("/Users/Austin/Desktop/dictionary.txt"));
			Scanner fileScanner2 = new Scanner(new File("/Users/Austin/Desktop/dictionary.txt"));
			String word;
			double score;
			String highScoreWord="";
			double highScore=0;
			wordComparison comp;
			while(fileScanner.hasNextLine()) {
				word=fileScanner.nextLine();
				score=0;
				while(fileScanner2.hasNextLine()) {
					comp=new wordComparison(word,fileScanner2.nextLine());
					score+=comp.getWeightedScore();
				}
				if(score>highScore) {
					highScore=score;
					highScoreWord=word;
					System.out.println(highScoreWord);
				}
				fileScanner2 = new Scanner(new File("/Users/Austin/Desktop/dictionary.txt"));
			}
			System.out.println("The optimal word is '"+highScoreWord+"' with a score of "+highScore);
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
