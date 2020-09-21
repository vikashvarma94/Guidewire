package GW.Guidewire.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import GW.Guidewire.base.baseclass;
import GW.Guidewire.pageobjects.Homepage;
import GW.Guidewire.pageobjects.Person;
import GW.Guidewire.pageobjects.login;
import cucumber.runtime.Timeout;

public class Tc4_Search_edit extends baseclass {
  @Test
  public void f() {
	  test  = report.createTest("search & edit");
	  driver.get("http://localhost:8880/ab/ContactManager.do");
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  login l = new login(driver);
	  Homepage h = new Homepage(driver);
	  Person p = new Person(driver);
	  
	  login.signin("su", "gw");
	  
	  Homepage.Contacttype.sendKeys("Contact"); 
	  Homepage.Lastname.sendKeys("varma");
	  Homepage.Searchbtn.click();
	  driver.findElement(By.linkText("vikas varma")).click();
	  Person.Details.click();
	  Person.Edit.click();
	  Person.Update.click();
	 // Person.Cancel.click();
	  
  }
}
