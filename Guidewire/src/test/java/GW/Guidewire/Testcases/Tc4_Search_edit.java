package GW.Guidewire.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;
import GW.Guidewire.pageobjects.Homepage;
import GW.Guidewire.pageobjects.Person;
import GW.Guidewire.pageobjects.Login;
import cucumber.runtime.Timeout;

public class Tc4_Search_edit extends baseclass {
  @Test
  /**
	 * Test for Edit & update person contact details
	 */
  public void f() throws InterruptedException {
	  test  = report.createTest("search & edit");
	  driver.get("http://localhost:8880/ab/ContactManager.do"); 
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  Login l = new Login(driver);
	  Homepage h = new Homepage(driver);
	  Person p = new Person(driver);
	  
	  Login.signin("su", "gw");
	  
	  Homepage.Contacttype.sendKeys("Contact"); 
	  Homepage.Lastname.sendKeys("varma");
	  Homepage.Searchbtn.click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("vikas varma")).click();
	  Person.Details.click();
	  Person.Edit.click();
	  Person.Country.sendKeys("Canada");
	  Person.Address1.sendKeys("test");
	  Person.Address2.sendKeys("test2");
	  Person.validdate.sendKeys("31/12/2020");
	  Person.Update.click();
	 // Person.Cancel.click();
	  
  }
}
