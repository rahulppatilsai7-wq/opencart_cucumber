package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import factory.BaseClass;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps {
	HomePage hp;
	MyAccountPage mp;
	LogInPage lp;
	
	List<HashMap<String,String>> data;

	@Given("Launch the application and navigate to login page")
	public void launch_the_application_and_navigate_to_login_page() {
		hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickLogIn();
		BaseClass.getLogger().info("User clicked on the login button under Myaccount dropdown");
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String psw) {
		BaseClass.getLogger().info("User enters email and password");
		lp = new LogInPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(psw);
	}

	@When("enter username and password as {string} {string}")
	public void enter_username_and_password_as(String username, String password) {
		lp = new LogInPage(BaseClass.getDriver());
		lp.setEmail(username.trim());
		lp.setPassword(password.trim());
	}

	@Then("user clicks on the login button")
	public void user_clicks_on_the_login_button() {
		BaseClass.getLogger().info("User clicks on the login button");
		lp.clickLogInbtn();
	}

	@Then("user should be redirected to the Myaccount page")
	public void user_should_be_redirected_to_the_myaccount_page() {
		BaseClass.getLogger().info("User is redirected to the MyAccount page");
		mp = new MyAccountPage(BaseClass.getDriver());
		boolean status = mp.isMyAccountTextPresent();
		Assert.assertEquals(true, status);
	}
	
	@When("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void enter_username_and_password_from_excel(String rows) {
		data=DataReader.data(System.getProperty("user.dir")+"\\testData\\Open_cart_login_test_data.xlsx","Sheet1");
		int index=Integer.parseInt(rows)-1;
		String email=data.get(index).get("username");
		String password=data.get(index).get("password");
		String exp_res=data.get(index).get("res");
		
		lp = new LogInPage(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogInbtn();
		
		mp = new MyAccountPage(BaseClass.getDriver());
		boolean status=mp.isMyAccountTextPresent();
		
		try {
		if(exp_res.equals("Valid")) {
			if(status==true) {
				mp.clickLogOutbtn();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			
		}
		if(exp_res.equals("Invalid")) {
			if(status==true) {
				mp.clickLogOutbtn();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
			
		}
		}catch(Exception e) {
			Assert.assertTrue(false);
		}
	}
}
