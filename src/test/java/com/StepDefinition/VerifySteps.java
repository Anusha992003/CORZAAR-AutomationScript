package com.StepDefinition;

import org.testng.Assert;

import com.Pages.VerifyPage;
import com.driverFactory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifySteps {
	private VerifyPage verifyPage;
	
	@Given("User clicks on verify module")
	public void user_clicks_on_verify_module() {
	    verifyPage=new VerifyPage(DriverFactory.getDriver());
	    verifyPage.clickVerify();
	    Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("verify"));
	}
	@When("User verifies the title of page")
	public void user_verifies_the_title_of_page() {
	   verifyPage.getTitle();
	}
	@When("User enters any certifiacte ID in the input field {string}")
	public void user_enters_any_certifiacte_id_in_the_input_field(String ID) {
	    verifyPage.enterID(ID);
	}
	@Then("User clicks on verify button")
	public void user_clicks_on_verify_button() {
	    verifyPage.clickSubmitBtn();
	}
	@Then("User clicks on verify button {string},{string}")
	public void user_clicks_on_verify_button(String id, String result) {
		verifyPage.clickSubmitBtn();
		verifyPage.validateID(id, result);
	}
	@Then("User validates the result after clicking submit button {string}")
	public void user_validates_the_result_after_clicking_submit_button(String id) {
		verifyPage=new VerifyPage(DriverFactory.getDriver());
		verifyPage.verifyAgain(id);
	    verifyPage.verifyCertificate();
	}

}
