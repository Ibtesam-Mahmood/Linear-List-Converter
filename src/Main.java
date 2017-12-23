import java.util.Scanner;

public class Main {

	
	
	public static void main(String[] args) {
		
		Scanner c = new Scanner(System.in);
		
		System.out.print("Common Spacing: ");
		
		String space = c.nextLine();
		
		FileReader reader = new FileReader(space);
		reader.read();
		
	}
	
}
