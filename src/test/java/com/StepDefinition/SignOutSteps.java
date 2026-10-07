package com.StepDefinition;

import com.Pages.ProfilePage;
import com.Pages.SignOutPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SignOutSteps {
	private SignOutPage signOutPage;
	
	@Given("User clicks on profile icon from dashboard")
	public void user_clicks_on_profile_icon_from_dashboard() {
		ProfilePage profilePage=new ProfilePage(DriverFactory.getDriver());
		profilePage.clickProfileIcon();
	    signOutPage=new SignOutPage(DriverFactory.getDriver());
	    
	}
	@Given("User clicks on signout option")
	public void user_clicks_on_signout_option() {
		signOutPage.clickSignOutOption();
	}
	@Then("User should be navigated to login page")
	public void user_should_be_navigated_to_login_page() {
	    signOutPage.verifySignOut();
	}


}
