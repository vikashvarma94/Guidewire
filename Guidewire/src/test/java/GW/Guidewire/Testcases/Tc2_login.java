package GW.Guidewire.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;
import GW.Guidewire.dataprovider.Login_TestData;
import GW.Guidewire.pageobjects.login;
import junit.framework.Assert;

public class Tc2_login extends baseclass  {
	
  @Test(groups = {"regration"})
  
  public void f() {
	  test = report.createTest("login");
	  
	 // WebDriver driver = new HtmlUnitDriver();
	 driver.get("http://localhost:8880/ab/ContactManager.do"); 
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	 login l = new login(driver);
	 login.signin("su","gw");

	 Assert.assertTrue(driver.findElement(By.id("image-1011")).isEnabled());
  }
}