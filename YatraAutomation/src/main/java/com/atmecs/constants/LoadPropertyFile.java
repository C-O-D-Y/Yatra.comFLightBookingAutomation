package com.atmecs.constants;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.utils.ReadPropertiesFile;

/**
 * In this class, property file is loaded for getting locators.
 */
public class LoadPropertyFile {
	static Properties property;

	/**
	 * In this constructor, reading of property file is being done.
	 */
	public LoadPropertyFile(String filePath) {
		try {
			property = ReadPropertiesFile.loadProperty(filePath);
		} catch (IOException e) {
			System.out.println("File path not found");
		}
	}

	/**
	 * In this method, locator data from the property file is taken.
	 * 
	 * @param key
	 */
	public static String getPropertyFileData(String key) {
		String value =property.getProperty(key);
		return value;
	}
}
