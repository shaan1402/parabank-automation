package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropOperations {
	
	Properties prop;
	
	//initialise the constructor, you're only going to load file in the constructor
	public PropOperations(String filepath) {
		//it will make the reference object of that file
		File file = new File(filepath);
		
		try {
			//it will open that file in read only mode, input stream to read from the file
			//FileOutputStream to write something in that file
			FileInputStream inputStream = new FileInputStream(file);
		
			//now we are going to load this file as a property file in the memory and for that we are going to use Properties class
			//now after doing this that config file would have been loaded as Property file in the memory
			prop = new Properties();
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} 
	}
	
	public String getValue(String key) {
		return prop.getProperty(key); 
	}
}
