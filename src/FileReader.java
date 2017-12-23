import java.io.File;

public class FileReader {

	private final String readDir = "C:\\Users\\ibtes\\Documents\\WorkSpaces\\Mini Functions\\Linear List Converter\\text files\\Base";
	private final String postDir = "C:\\Users\\ibtes\\Documents\\WorkSpaces\\Mini Functions\\Linear List Converter\\text files\\Converted";
	
	private String spacing;
	
	public FileReader(String spacing) {
		this.spacing = spacing;
	}
	
	public void read() {
		
		if(!checkEmptyDirectory())
			return;
		
		
		
	}
	
	private boolean checkEmptyDirectory() {
		
		File[] files = (new File(readDir)).listFiles();
		
		if(files.length == 0) {
			System.out.println("No Files to Convert");
			return false;
		}
		else
			return true;
		
	}
	
}
