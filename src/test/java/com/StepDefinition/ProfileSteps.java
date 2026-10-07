package com.StepDefinition;

import org.testng.Assert;

import com.Pages.ProfilePage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps {
	private ProfilePage profilePage;
	
	
	@Given("User clicks on profile icon")
	public void user_clicks_on_profile_icon() {
	    profilePage=new ProfilePage(DriverFactory.getDriver());
	    profilePage.clickProfileIcon();
	}
	@Given("User should click on My Profile option")
	public void user_should_click_on_my_profile_option() {
		profilePage.clickProfileModule();
	}
	@Then("User should be navigated to profile page")
	public void user_should_be_navigated_to_profile_page() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("profile"));
	}
	@Then("User verifies the title")
	public void user_verifies_the_title() {
	    profilePage.getTitle();
	}
	@When("User enters the email {string}")
	public void user_enters_the_email(String mail) {
	    profilePage.enterMail(mail);
	}
	@When("User clicks on save button")
	public void user_clicks_on_save_button() {
	    profilePage.clickSaveBtn();
	}
	@Then("User verifies the changes")
	public void user_verifies_the_changes() {
	    profilePage.getMsg();
	}

}
