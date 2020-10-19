package GW.Guidewire.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Login {

	 public static WebDriver driver;
	 
	 @FindBy (id="Login:LoginScreen:LoginDV:username-inputEl") public static WebElement username;
	 @FindBy (id="Login:LoginScreen:LoginDV:password-inputEl")  public static WebElement password;
	 @FindBy (xpath="//tbody/tr/td/a") public static WebElement submit;
	 
	 public Login(WebDriver driver) {
		 Login.driver=driver;
		 PageFactory.initElements(driver, this);}
	 
	 public static void signin(String u, String p) {
		 username.sendKeys(u);
		 password.sendKeys(p);
		 submit.click();
	 }
	 
  }

