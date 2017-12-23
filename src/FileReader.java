import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.apache.commons.io.IOUtils;

public class FileReader {

	/*
	 * A file reader that reads spaces between words
	 * Then converts them into a linear list
	 */
	
	//Directory the files are looked for in
	private final String readDir = "C:\\Users\\ibtes\\Documents\\WorkSpaces\\Mini Functions\\Linear List Converter\\text files\\Base";
	
	//Directory the files will be transfered to
	private final String postDir = "C:\\Users\\ibtes\\Documents\\WorkSpaces\\Mini Functions\\Linear List Converter\\text files\\Converted";
	
	private String spacing; //The common spacing between the words
	
	public FileReader(String spacing) {
		this.spacing = spacing;
	}
	
	//Main functionality of the program
	public void parse() {
		
		if(!checkEmptyDirectory()) //Exits code if the base directory is empty
			return; 
		
		File[] files = (new File(readDir)).listFiles(); //Creates a list of all files within the base directory
		
		
		for (int i = 0; i < files.length; i++) {
			
			String text = "";
			
			try(FileInputStream inputStream = new FileInputStream(files[i])) {     
			    text = IOUtils.toString(inputStream, "US-ASCII"); //Parses the text into a string
			} catch (IOException e) { e.printStackTrace(); } 
			
			if(!containsSpacing(text, spacing, files[i]))
				continue; //Continues to the next file if the spacing is not present
			
			String[] list = text.split(spacing); //Splits the text based off the common spacing
			
			printToFile(list, files[i]); //Changes the files into a linear list in the converted folder

		}	
		
		System.out.println("Files Converted");
	}
	
	//Deletes the file given
	//@param file - the file to be deleted
	private void deleteFile(File file) {
		file.delete(); 
	}
	
	//Prints a linear list of the file given
	//@param list - the text within the given file
	//@param file - the file itself
	private void printToFile(String[] list, File file) {
		
		try (Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(postDir + "\\" + file.getName()) )) ) {
			
			//Loops through the text and prints it linearly
			for (int i = 0; i < list.length; i++) {
				writer.write(list[i]);
				if(i != list.length - 1)
					writer.write(" \n");
			}
			
		} catch (IOException e) { e.printStackTrace(); }
		
		//deleteFile(file);
		
	}
	
	//Checks if the base directory is empty
	private boolean checkEmptyDirectory() {
		
		File[] files = (new File(readDir)).listFiles();
		
		if(files.length == 0) {
			System.out.println("No Files to Convert");
			return false;
		}
		else
			return true;
		
	}
	
	//Checks if the file contains the spacing
	//@param text - the text of the file
	//@param spacing - the specific spacing
	//@param file - the file which is being checked
	private boolean containsSpacing(String text, String spacing, File file) {
		if(text.contains(spacing))
			return true;
		else {
			System.out.println(file.getName() + " does not contain the specific spacing and will not be converted");
			return false;
		}
	}
	
}
