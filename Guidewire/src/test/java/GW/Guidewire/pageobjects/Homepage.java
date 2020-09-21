package GW.Guidewire.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Homepage {
	public static WebDriver driver;
 
	@FindBy(xpath="//span[contains(text(),\"ctions\")]") public static WebElement Actions;
	@FindBy(xpath="//span[contains(text(),\"Search\")]") public static WebElement Search;
	@FindBy(xpath="(//div/a/span)[3]") public static WebElement Admin;
	
	@FindBy(xpath="(//div/div/a/span)[19]") public static WebElement Newperson;
		@FindBy(xpath="(//div/div/a/span)[23]") public static WebElement Person;
		@FindBy(xpath="(//div/div/a/span)[24]") WebElement Adjudicator;
		@FindBy(xpath="(//div/div/a/span)[25]") WebElement usercontact;
		@FindBy(xpath="(//div/div/a/span)[26]") WebElement policyperson;
		@FindBy(xpath="(//div/div/a/span)[27]") WebElement Vendor;
			@FindBy(xpath="(//div/div/div/a/span)[26]") WebElement PersonVendor;
			@FindBy(xpath="(//div/div/div/a/span)[27]") WebElement Attorney;
			@FindBy(xpath="(//div/div/div/a/span)[28]") WebElement Doctor;
			
	@FindBy(xpath="(//div/div/a/span)[20]") WebElement Newcompany;
		@FindBy(xpath="(//div/div/div/a/span)[18]") WebElement Company;
		@FindBy(xpath="(//div/div/div/a/span)[19]") WebElement PolicyCompany;
		@FindBy(xpath="(//div/div/div/a/span)[20]") WebElement Companyvendor;
			//@FindBy(xpath="(//div/div/div/a/span)[20]") WebElement Companyvendor;
		
	@FindBy(xpath="(//div/div/a/span)[21]") WebElement Newplace;
	@FindBy(xpath="(//div/div/a/span)[22]") WebElement Gotoguidewire;
	
	@FindBy(id="ABContactSearch:ABContactSearchScreen:ContactSearchDV:GlobalContactNameInputSet:Name-inputEl")
	public static WebElement Lastname;
	@FindBy(id="ABContactSearch:ABContactSearchScreen:ContactSearchDV:ContactSubtype-inputEl")
	public static WebElement Contacttype;
	
	@FindBy(id="ABContactSearch:ABContactSearchScreen:ContactSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Search")
	public static WebElement Searchbtn;
	@FindBy(id="ABContactSearch:ABContactSearchScreen:ContactSearchDV:SearchAndResetInputSet:SearchLinksInputSet:Reset")
	public static WebElement Reset;
	
	
	
	public Homepage (WebDriver driver) {
		Homepage.driver = driver;
		PageFactory.initElements(driver, this);}
	
	
}
