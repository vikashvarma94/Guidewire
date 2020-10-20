package GW.Guidewire.Testcases;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;
import GW.Guidewire.dataprovider.Login_TestData;
import GW.Guidewire.pageobjects.Login;
import junit.framework.Assert;

public class Tc2_login extends baseclass  {
	/**
	 * Testing Login functionality
	 */	
  @Test(groups = {"sanity"})
  	public void login_test() {
	  test = report.createTest("login");
	  driver.get("http://localhost:8880/ab/ContactManager.do"); 
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	  Login l = new Login(driver);
	  Login.signin("su","gw");

	  Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'ctions')]")).isEnabled());
  }
}