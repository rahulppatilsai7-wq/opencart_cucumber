package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;

public class LoginSteps {
	WebDriver driver;
	HomePage hp;
	MyAccountPage mp;
	LogInPage lp;

	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		BaseClass.getLogger().info("Go to Myaccount, click login button");
		hp= new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogIn();
	    
	}

	@Then("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String psw) {
		BaseClass.getLogger().info("User enters email and password");
		lp= new LogInPage(BaseClass.getDriver());
	 lp.setEmail(email);
	 lp.setPassword(psw);
	 
	}

	@Then("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		BaseClass.getLogger().info("User clicks on the login button");
	   lp.clickLogInbtn();
	}

	@Then("user should be redirected to the Myaccount page")
	public void user_should_be_redirected_to_the_myaccount_page() {
	    BaseClass.getLogger().info("User is redirected to the MyAccount page");
	    mp= new MyAccountPage(BaseClass.getDriver());
	    boolean status= mp.isMyAccountTextPresent();
	}
}
