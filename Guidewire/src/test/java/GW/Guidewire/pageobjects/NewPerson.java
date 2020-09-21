package GW.Guidewire.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class NewPerson {
	public static WebDriver driver;
		@FindBy(name="NewContact:ABContactDetailScreen:ContactBasicsDV:GlobalPersonNameInputSet:FirstName") 
		public static WebElement Firstname;
		@FindBy(name="NewContact:ABContactDetailScreen:ContactBasicsDV:GlobalPersonNameInputSet:LastName")
		public static WebElement Lastname;
		@FindBy(name="NewContact:ABContactDetailScreen:ContactBasicsDV:TaxID")
		public static WebElement Taxid;
		@FindBy(id="NewContact:ABContactDetailScreen:ContactBasicsDV:PrimaryAddressInputSet:AddressOwnerInputSet:globalAddressContainer:GlobalAddressInputSet:Country-inputEl")
		public static WebElement Country;
		@FindBy(id="NewContact:ABContactDetailScreen:ContactBasicsDV:PrimaryAddressInputSet:AddressOwnerInputSet:globalAddressContainer:GlobalAddressInputSet:AddressLine1-inputEl")
		public static WebElement Address1;
		
		@FindBy(id="NewContact:ABContactDetailScreen:ContactBasicsDV_tb:Update-btnInnerEl")
		public static WebElement Update;
		@FindBy(id="NewContact:ABContactDetailScreen:ContactBasicsDV_tb:Cancel-btnInnerEl")
		public static WebElement Cancel;
		
		public NewPerson (WebDriver driver) {
			NewPerson.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
}
