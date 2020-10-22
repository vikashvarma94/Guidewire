package GW.Guidewire.base;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;

import GW.Guidewire.utills.Readconfig;

public class baseclass {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String browsername = null;
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd HH_mm_ss");  
	public static LocalDateTime now = LocalDateTime.now();
	public Logger log;	

	@BeforeSuite(alwaysRun = true)
	  	public void suite() {  
		 ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//Reports/"+dtf.format(now)+".html");
		    report = new ExtentReports(); 
		    report.attachReporter(reporter);
		    }
	
	//@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
		public void setup() throws IOException {//String browsername	
		Readconfig.getproperties();  
		log=Logger.getLogger("Guidewire");
		PropertyConfigurator.configure("log4j.properties");
	 	
		if(browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();	}
			  
		else if(browsername.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();}
		
		else if(browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();} 
		
		else if(browsername.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();}
		
		// else { 	driver = new HTMLunitdriver();}  
		log.info("***** "+browsername+" Browser Launched ******");
	}
  

  @AfterMethod(alwaysRun = true)
  		public void endtest(ITestResult result) throws IOException {
	
	if(result.getStatus()==ITestResult.FAILURE)
	{	log.info("***** Test Method failed ******");
		String temp=Utility.getScreenshot(driver);	
		test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	else {log.info("***** Test Method Passed ******");}
	
	driver.close();
	log.info("***** Browser Closed ******");
	report.flush();
	//Readconfig.setproperties();
	}


		public static class Utility 
	{
	public static String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"//Screnshots/"+dtf.format(now)+".png";
		File destination=new File(path);
			try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
		
			System.out.println("Capture Failed "+e.getMessage());
		}
		return path;
	}}}
