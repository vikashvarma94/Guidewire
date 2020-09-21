package GW.Guidewire.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Person {
	public static WebDriver driver;
	@FindBy(xpath="//span[contains(text(),\"Details\")]") 
	public static WebElement Details;
		@FindBy(id="ABContactDetailsPage:Edit-btnInnerEl")
		public static WebElement Edit;
		@FindBy(xpath="//span[contains(text(),\"U\")]")
		public static WebElement Update;
		@FindBy(xpath="//span[contains(text(),\"Cance\")]")
		public static WebElement Cancel;
	
	@FindBy(id="NewContact:ABContactDetailScreen:ContactBasicsDV_tb:Update-btnInnerEl")
	public static WebElement Update1;
	@FindBy(id="NewContact:ABContactDetailScreen:ContactBasicsDV_tb:Cancel-btnInnerEl")
	public static WebElement Cancel1;
	
	public Person (WebDriver driver) {
		NewPerson.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
