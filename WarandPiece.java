import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class WarandPiece {

	public static void main(String[] args) throws FileNotFoundException {
		File warAndPiece = new File("WAP.txt");
		Scanner sc = new Scanner(warAndPiece);
		int war = 0;
		int peace = 0;
		while(sc.hasNextLine()){
			String row = sc.nextLine();
			row.toLowerCase();
			String [] words = row.split(" ");
			for(String s : words){
				if(s.equals("война")){
					war++;
				}
				if(s.equals("мир")){
					peace++;
				}
			}
		}
		System.out.println("War - " +  war);
		System.out.println("Peace - " +  peace);
		
		

	}

}
