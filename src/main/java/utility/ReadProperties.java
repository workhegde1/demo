package main.java.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	public static Properties readConfig() throws IOException {
		Properties pro=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		pro.load(fis);
		fis.close();
		return pro;
		}
	}
