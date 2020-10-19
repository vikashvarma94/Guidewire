package GW.Guidewire.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;
import GW.Guidewire.dataprovider.Login_TestData;
import GW.Guidewire.pageobjects.Login;
import junit.framework.Assert;

public class Tc1_login extends baseclass {
	/**
	 * Testing Login functionality with test data from xl file
	 */	
  @Test(dataProvider = "login",dataProviderClass = Login_TestData.class)
 
  		public void login_test(String url,String u,String p, String expected) {
	  	test = report.createTest("login");
	  	driver.get(url); 
	  	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	  	Login l = new Login(driver);
	  	l.signin(u,p);

	  	Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'ctions')]")).isEnabled());
  }
}
