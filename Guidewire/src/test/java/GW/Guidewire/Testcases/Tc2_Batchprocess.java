package GW.Guidewire.Testcases;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;
import GW.Guidewire.dataprovider.Login_TestData;
import GW.Guidewire.pageobjects.Login;
import junit.framework.Assert;

public class Tc2_Batchprocess extends baseclass  {
	/**
	 * Check batch process
	 */	
  @Test(groups = {"sanity"})
  	public void Batchprocess() throws InterruptedException {
	  test = report.createTest("Batchprocess");
	  driver.get("http://localhost:8880/ab/ContactManager.do"); 
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	  Login l = new Login(driver);
	  Login.signin("su","gw");
	  Actions action = new Actions(driver);
	  Thread.sleep(5000);
	  action.keyDown(Keys.ALT).keyDown(Keys.SHIFT).sendKeys("T").build().perform();
	  action.keyUp(Keys.ALT).keyUp(Keys.SHIFT).build().perform();
	 
	  List<WebElement> li =driver.findElements(By.xpath("(//table/tbody)[9]/tr/td/div"));
	  for(int i = 1; i<=li.size(); i++) {
		  String s = li.get(i).getText();
		  System.out.println(s);
	  if (s.contains("Database Statistics")) {
		  System.out.println("Database Statistics batch process is exist");
		  break;}
	  else if(i==li.size()-1) {
		  System.out.println("Database Statistics batch process is not exist");
	  }}
	 
  }
}