package stepDefinitions;

import java.util.Map;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class AccountRegistrationSteps {
	HomePage hp;
	RegistrationPage rp;

	@Given("User launches the application and navigates to  Account registration page")
	public void user_launches_the_application_and_navigates_to_account_registration_page() {
	   hp=new HomePage(BaseClass.getDriver());
	   hp.clickMyAccount();
	   hp.clickRegister();
	   BaseClass.getLogger().info("Clciked registration link");
	}

	@When("Enter the below details in the given field")
	public void enter_the_below_details_in_the_given_field(DataTable dataTable) {
		Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
		
		rp=new RegistrationPage(BaseClass.getDriver());
		rp.setFirstName(dataMap.get("First name"));
		rp.setLastName(dataMap.get("Last name"));
		rp.setEmail(BaseClass.randomeString()+"@gmail.com");
		rp.setTelePhone(dataMap.get("Telephone"));
		rp.setPassword(dataMap.get("password"));
		rp.setConfirmPassword(dataMap.get("password"));
		BaseClass.getLogger().info("Provided the necessary fields");

	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		rp.clickPolicyCheckBox();
		BaseClass.getLogger().info("Checked the privacy policy");
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		rp.clickContinue();
		BaseClass.getLogger().info("Clicked on the continue button");
	}

	@Then("Account will be created")
	public void account_will_be_created() {
	    System.out.println(rp.getConfirmationMsg()); 
	}
}
