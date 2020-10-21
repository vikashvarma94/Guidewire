package GW.Guidewire.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Batchprocess {
	 public static WebDriver driver;
	 
	 @FindBy (xpath="(//table/tbody)[9]/tr/td/div") public static WebElement Batchprocessname;
	 @FindBy (id="Login:LoginScreen:LoginDV:password-inputEl")  public static WebElement password;
	 @FindBy (xpath="//tbody/tr/td/a") public static WebElement submit;
	 
	 public Batchprocess(WebDriver driver) {
		 Login.driver=driver;
		 PageFactory.initElements(driver, this);}
}
