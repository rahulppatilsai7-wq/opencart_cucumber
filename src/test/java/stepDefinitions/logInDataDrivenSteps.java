package stepDefinitions;
import factory.BaseClass;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;

public class logInDataDrivenSteps {
	 HomePage hp;
	 LogInPage lp;
	 MyAccountPage map;

	@Given("Launch the application and navigate to login page")
	public void launch_the_application_and_navigate_to_login_page() {
	  hp=new HomePage(BaseClass.getDriver());
	  hp.clickMyAccount();
	  hp.clickLogIn();
	  BaseClass.getLogger().info("User clicked on the login button under Myaccount dropdown");
	}

	@Then("enter username and password as {string} {string}")
	public void enter_username_and_password_as(String username, String password) {
		lp=new LogInPage(BaseClass.getDriver());
	 lp.setEmail(username);
	 lp.setPassword(password);
	}

	@Then("click login button")
	public void click_login_button() {
		map=new MyAccountPage(BaseClass.getDriver());
	  lp.clickLogInbtn();
	  boolean text=map.isMyAccountTextPresent();
	  Assert.assertEquals(true, text);
	}
}
