package GW.Guidewire.utills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import GW.Guidewire.base.baseclass;

public class Readconfig {
	static Properties prop = new Properties();

	public static void main(String[] args) throws IOException {
		getproperties();
		setproperties();
	}
	public static void getproperties() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\GW\\Guidewire\\utills\\config.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		baseclass.browsername = prop.getProperty("browser");
	}
	
	public static void setproperties() throws IOException {
		
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\java\\GW\\Guidewire\\utills\\config.properties");
		prop.setProperty("result", "Pass");
		prop.store(fos, null);
		
	}
}
