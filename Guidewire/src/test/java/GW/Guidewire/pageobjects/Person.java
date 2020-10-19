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
		@FindBy(xpath="//span[contains(text(),\"dit\")]")
		public static WebElement Edit;
		@FindBy(xpath="//span[contains(text(),\"pdate\")]")
		public static WebElement Update;
		@FindBy(xpath="//span[contains(text(),\"Cance\")]")
		public static WebElement Cancel;
	
	@FindBy(id="ABContactSummaryPage:ABContactSummaryScreen:ABContactSummaryDV:AddressOwnerInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl") 
	public static WebElement Country;
	@FindBy(id="ABContactSummaryPage:ABContactSummaryScreen:ABContactSummaryDV:AddressOwnerInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl") 
	public static WebElement Address1;
	@FindBy(id="ABContactSummaryPage:ABContactSummaryScreen:ABContactSummaryDV:AddressOwnerInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine2-inputEl") 
	public static WebElement Address2;
	@FindBy(id="ABContactSummaryPage:ABContactSummaryScreen:ABContactSummaryDV:AddressOwnerInputSet:Address_ValidUntil-inputEl") 
	public static WebElement validdate;
	
	
	public Person (WebDriver driver) {
		NewPerson.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
