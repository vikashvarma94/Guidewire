package GW.Guidewire.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;
import GW.Guidewire.dataprovider.Login_TestData;
import GW.Guidewire.pageobjects.login;
import junit.framework.Assert;

public class Tc1_login extends baseclass {
	
  @Test(dataProvider = "login",dataProviderClass = Login_TestData.class)
  
  public void f(String url,String u,String p, String expected) {
	 test = report.createTest("login");
	 driver.get(url); 
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	 login l = new login(driver);
	 l.signin(u,p);

	 Assert.assertTrue(driver.findElement(By.id("image-1011")).isEnabled());
  }
}
