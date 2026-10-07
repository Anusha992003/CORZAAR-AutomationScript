package com.StepDefinition;

import org.testng.Assert;

import com.Pages.HomePage;
import com.Pages.OffersPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OffersSteps {
	private OffersPage offersPage;
	
	@Given("User clicks on offers module")
	public void user_clicks_on_offers_module() {
	    offersPage=new OffersPage(DriverFactory.getDriver());
	    offersPage.clickOffers();
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("offers"));
	}
	@Given("User verifies the title of offers page")
	public void user_verifies_the_title_of_offers_page() {
	    offersPage.getTitle();
	}
	@Then("User clicks on copy option of any card")
	public void user_clicks_on_copy_option_of_any_card() {
	    offersPage.clickCopy();
	    offersPage.getCopyMsg();
	}
	@Then("User clicks on Get My Referral code button")
	public void user_clicks_on_get_my_referral_code_button() {
	    offersPage.clickCodeBtn();
	}
	@Then("User verifies the page navigation to wallet page")
	public void user_verifies_the_page_navigation_to_wallet_page() {
	   Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("wallet"));
	}

}
