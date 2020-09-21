package GW.Guidewire.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.html.dom.HTMLDirectoryElementImpl;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class baseclass {
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;

	public String id="1";	
	public Logger logger;
	
	@BeforeClass
	public void setUp() {
		logger=Logger.getLogger("EmployeesRestAPI");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
				}

	@BeforeSuite
	  public void suite() {  
		 ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//Reports/extent report.html");
		    report = new ExtentReports(); 
		    report.attachReporter(reporter);
		    }

  @BeforeMethod
  public void setup() {
		String browser = " ";
		
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();	}
		  
		else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();}
		
		else if(browser.equalsIgnoreCase("Unit")) {
			driver = new HtmlUnitDriver();}
			  
		else {
			System.setProperty("webdriver.edge.driver","C:\\Users\\151508\\eclipse-workspace\\Guidewire\\src\\drivers\\msedgedriver.exe");
			//Main.class.getProtectionDomain().getCodeSource() + "/msedgedriver.exe");
			driver = new EdgeDriver();}
		  	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
  

@AfterMethod
public void endtest(ITestResult result) throws IOException {
	
	if(result.getStatus()==ITestResult.FAILURE)
	{
		String temp=Utility.getScreenshot(driver);	
		test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	driver.close();
	report.flush();
	}


@AfterSuite
	public void afterSuite() throws InterruptedException, IOException {	
//report.flush();
  }

	public static class Utility 
	{
	public static String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"//Scren Shorts/"+System.currentTimeMillis()+".png";
		
		File destination=new File(path);
		
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}
		return path;
	}}}
