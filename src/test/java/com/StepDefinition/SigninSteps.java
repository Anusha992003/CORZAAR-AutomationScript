package com.StepDefinition;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Pages.SigninPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SigninSteps {
	
	private SigninPage signinPage = new SigninPage(DriverFactory.getDriver());
	
	@Given("User is on signin page")
	public void user_is_on_signin_page() {
		signinPage.clickSiginBtn();
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
	    Assert.assertTrue(signinPage.getPageTitle());
	}
	@When("User enters Learner mobile number {string}")
	public void user_enters_learner_mobile_number(String mobile) {
	    signinPage.enterMobileNumber(mobile);
	}
	@And("User enters Full name {string}>")
	public void user_enters_full_name(String name) {
	    signinPage.enterFullName(name);
	}
	@And("User clicks on Send OTP button")
	public void user_clicks_on_send_otp_button() {
	   signinPage.clickSendOtpBtn();
	}
	@Then("User should navigate to otp verification page {string}")
	public void user_should_navigate_to_otp_verification_page(String result) {
		switch (result.toLowerCase()) {
		case "invalid":
			signinPage.getMsgForInvalidMobile();
		break;	
		} 
	}
	
	
	@Given("User enters OTP {string},{string},{string}")
	public void user_enters_otp(String mobile, String name, String otp) {
		signinPage.clickSiginBtn();
		signinPage.otpPageNavigation(mobile, name);
	    signinPage.enterOTP(otp);
	}
	@And("User clicks on Verify & enter learning space button")
	public void user_clicks_on_verify_enter_learning_space_button() {
	    signinPage.clickSubmitBtn();
	}
	@Then("User should navigate to home page {string}")
	public void user_should_navigate_to_home_page(String result) {
		switch (result.toLowerCase()) {
		case "invalid":
			signinPage.getMsgForInvalidOtp();
		break;	
		case "valid":
			//Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("learning"));
		    signinPage.getHomePageTitle();   
		break;
		}
	}


	}
