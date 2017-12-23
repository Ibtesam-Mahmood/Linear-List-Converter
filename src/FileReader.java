import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.io.IOUtils;

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
		
		File[] files = (new File(readDir)).listFiles();
		
		for (int i = 0; i < files.length; i++) {
			
			String text = "";
			
			try(FileInputStream inputStream = new FileInputStream(files[i])) {     
			    text = IOUtils.toString(inputStream, "US-ASCII");
			} catch (IOException e) { e.printStackTrace(); }
			
			System.out.println(text);
			
			String[] list = text.split(spacing);
			
			printToFile(list, files[i]);

		}	
	}
	
	private void deleteFile(File file) {
		file.delete();
	}
	
	private void printToFile(String[] list, File file) {
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(postDir + "\\" + file.getName()) )) ) {
			
			for (int i = 0; i < list.length; i++) {
				writer.write(list[i]);
				if(i != list.length - 1)
					writer.write("\n");
			}
			
		} catch (IOException e) { e.printStackTrace(); }
		
		deleteFile(file);
		
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
