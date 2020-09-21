package GW.Guidewire.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;
import GW.Guidewire.dataprovider.Login_TestData;
import GW.Guidewire.dataprovider.Newperson_TestData;
import GW.Guidewire.pageobjects.Homepage;
import GW.Guidewire.pageobjects.NewPerson;
import GW.Guidewire.pageobjects.login;


public class Tc3_CreateNewperson extends baseclass {
	 @Test(dataProvider = "New person",dataProviderClass = Newperson_TestData.class)
	  
	  public void b(String url,String first,String last,String Taxid) {
		 test = report.createTest("New person");
		 driver.get(url); 
		 
		 driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 login l = new login(driver);
		 Homepage h = new Homepage(driver);
		 NewPerson np= new NewPerson(driver);
		 
		 login.signin("su","gw");
	
		 Homepage.Actions.click();
		 Homepage.Newperson.click();
		 Homepage.Person.click();
		 NewPerson.Firstname.sendKeys(first);
		 NewPerson.Lastname.sendKeys(last);
		 NewPerson.Taxid.sendKeys(Taxid);
		 NewPerson.Update.click();
		 
		 Assert.assertEquals(driver.findElement(By.className("infobar_elem_val")).getText(), first+" "+last);
  }
}
