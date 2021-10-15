package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	
	/**
	 * This method is used to load the Properties from  config.properties file
	 * @return Properties properties Object 
	 */
	public Properties initConfigProperties() {
		
		properties = new Properties();
		
		// Interact with config.properties file
		try {
			FileInputStream configProperties = new FileInputStream("./src/test/resources/config/config.properties");
			properties.load(configProperties);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
		
	}
	
}
