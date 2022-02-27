import java.io.*;
import java.util.Scanner;

public class fileWriteDriver {
	public final static String DELIM="\t";
	public static void main(String[] args) {
		fileReadAndWrite();
	}
	
	public static void fileReadAndWrite ()
	{
		try
		{
			Scanner fileScanner = new Scanner(new File("/Users/Austin/Desktop/dictionary.txt"));
			int lineCount=0;
			while(fileScanner.hasNextLine()) {
				lineCount++;
				fileScanner.nextLine();
			}
			fileScanner = new Scanner(new File("/Users/Austin/Desktop/dictionary.txt"));
			Scanner fileScanner2 = new Scanner(new File("/Users/Austin/Desktop/dictionary.txt"));
			BufferedWriter bw =new BufferedWriter(new FileWriter("C:\\Users\\Austin\\Desktop\\wordleOutput.txt"));
			String word;
			double scoreG;
			double scoreY;
			wordComparison comp;
			while(fileScanner.hasNextLine()) {
				word=fileScanner.nextLine();
				scoreG=0;
				scoreY=0;
				while(fileScanner2.hasNextLine()) {
					comp=new wordComparison(word,fileScanner2.nextLine());
					scoreG+=comp.getGreen();
					scoreY+=comp.getYellow();
				}
				bw.write(word+DELIM+(scoreG/lineCount)+DELIM+(scoreY/lineCount)+"\n");
				fileScanner2 = new Scanner(new File("/Users/Austin/Desktop/dictionary.txt"));
			}
			bw.close();
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
