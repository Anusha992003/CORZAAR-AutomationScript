package com.StepDefinition;

import org.testng.Assert;

import com.Pages.HomePage;
import com.Pages.SigninPage;
import com.driverFactory.DriverFactory;
import com.utilities.ConstantUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomepageSteps {
	private HomePage homePage;
	
	@Given("User login with valid credentials")
	public void user_login_with_valid_credentials() {
		SigninPage signinPage = new SigninPage(DriverFactory.getDriver());
		homePage=signinPage.doLogin(ConstantUtils.MOBILENUMBER, ConstantUtils.NAME, ConstantUtils.OTP);
	} 
	
	
	@Given("User enters the text in search field {string}")
	public void user_enters_the_text_in_search_field(String search) {
		homePage.clickHomePageBtn();
	    homePage.getHomePageTitle();
	    homePage.enterTextInSearchField(search);
	}
	@And("User clicks on Explore courses button")
	public void user_clicks_on_explore_courses_button() {
	    homePage.clickExploreBtn();
	}
	@Then("User verifies the search result {string},{string}")
	public void user_verifies_the_search_result(String result, String search) {
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("courses"));
	    
	    switch (result) {
	    case "empty":
	    	homePage.verifySearchCount();
	    	System.out.println("All courses are displayed when the search is empty");
	    	break;
		case "invalid":
			homePage.verifySearchCount();
			homePage.verifyInvalidSearch();
			break;

		case "valid":
			homePage.verifySearchCount();
			homePage.verifySearchResult();
			break;
		}
	}

}
