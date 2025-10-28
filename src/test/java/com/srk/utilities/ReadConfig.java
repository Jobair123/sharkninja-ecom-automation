package com.srk.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	static Properties properties;
	static String path = "C:\\Users\\jobai\\eclipse-workspace\\Srk_Nijna\\Configuration\\config.properties";
	 public static void loadConfig() {
		 
	        try {
	            FileInputStream file = new FileInputStream(path);
	            properties = new Properties();
	            properties.load(file);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public static String getUrl() {
	        if (properties == null) {
	            loadConfig();
	        }
	        return properties.getProperty("url");
	    }
	 public static String getBrowser() {
	        if (properties == null) {
	            loadConfig();
	        }
	        return properties.getProperty("browser");
	    }
}
