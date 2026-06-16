package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement lnkLogIn;
	
	@FindBy(xpath="//input[@name='search']")
	WebElement txtSearchBar;	
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;	
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogIn() {
		lnkLogIn.click();
	}
	
	public void sendTextInTheSearchBar(String txt) {
		txtSearchBar.sendKeys(txt);
	}
	
	public void clickSearchButton() {
		btnSearch.click();
	}
}
